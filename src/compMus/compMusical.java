/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compMus;

/**
 *
 * @author hgoncalves
 */
import csnd6.csnd6;
import csnd6.Csound;
import csnd6.CsoundPerformanceThread;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class compMusical {

    public compMusical(String arquivo, String efeito) {

        csnd6.csoundInitialize(csnd6.CSOUNDINIT_NO_ATEXIT
                | csnd6.CSOUNDINIT_NO_SIGNAL_HANDLER);
        if (efeito.equals("Flanger")) {

            final String orc = "<CsoundSynthesizer>\n"
                    + "<CsOptions>\n"
                    + "; Select audio/midi flags here according to platform\n"
                    + "-odac     ;;;RT audio out\n"
                    + ";-iadc    ;;;uncomment -iadc if RT audio input is needed too\n"
                    + "; For Non-realtime ouput leave only the line below:\n"
                    + " -o flanger.wav -W ;;; for file output any platform\n"
                    + "</CsOptions>\n"
                    + "<CsInstruments>\n"
                    + "\n"
                    + "sr     = 44100\n"
                    + "ksmps  = 32\n"
                    + "nchnls = 2\n"
                    + "0dbfs  = 1\n"
                    + "\n"
                    + "\n"
                    + "instr 1\n"
                    + "\n"
                    + "kfeedback = p4\n"
                    + "avoice in\n"
                    + "asnd   diskin2\"" + arquivo + "\", 1, 0, 1\n"
                    + "adel linseg 0, p3*.5, 0.02, p3*.5, 0	;max delay time =20ms	\n"
                    + "aflg flanger asnd, adel, kfeedback\n"
                    + "asig clip aflg, 1, 1\n"
                    + "outs asig+asnd, asig+asnd		;mix flanger with original\n"
                    + "\n"
                    + "endin\n"
                    + "</CsInstruments>\n"
                    + "<CsScore>\n"
                    + "\n"
                    + "i 1 0 10 .2\n"
                    + "i 1 11 10 .8	;lot of feedback\n"
                    + "e\n"
                    + "\n"
                    + "</CsScore>\n"
                    + "</CsoundSynthesizer>";
            System.out.println(orc);

            Writer writer = null;
            String file = "testeFlanger.csd";
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file), "utf-8"));
                writer.write(orc);
            } catch (IOException ex) {
                // report
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {/*ignore*/
                }
            }

            System.out.println(orc);
            final Csound c = new Csound();

            c.Compile(file);
            c.Start();
            c.Perform();
            c.Stop();
        } else if (efeito.equals("Distortion")) {

            final String orc = "<CsoundSynthesizer>\n"
                    + "<CsOptions>\n"
                    + "; Select audio/midi flags here according to platform\n"
                    + "-odac     ;;;RT audio out\n"
                    + ";-iadc    ;;;uncomment -iadc if RT audio input is needed too\n"
                    + "; For Non-realtime ouput leave only the line below:\n"
                    + " -o distort.wav ;;; for file output any platform\n"
                    + "</CsOptions>\n"
                    + "<CsInstruments>\n"
                    + "\n"
                    + "sr     = 44100\n"
                    + "ksmps  = 32\n"
                    + "nchnls = 2\n"
                    + "0dbfs  = 1\n"
                    + "\n"
                    + "gifn	 ftgen	0,0, 257, 9, .5,1,270	; define a sigmoid, or better \n"
                    + ";gifn	ftgen	0,0, 257, 9, .5,1,270,1.5,.33,90,2.5,.2,270,3.5,.143,90,4.5,.111,270\n"
                    + "\n"
                    + "instr 1\n"
                    + "avoice in\n"
                    + "asig   diskin2 \"beats.wav\", 1, 0, 1\n"
                    + "\n"
                    + "kdist	line	0, p3, 2		; and over 10 seconds\n"
                    + ";asig 	poscil	0.3, 440, 1\n"
                    + "\n"
                    + "aout 	distort	asig, kdist, gifn	; gradually increase the distortion\n"
                    + "	outs	 	aout, aout\n"
                    + "\n"
                    + "endin\n"
                    + "</CsInstruments>\n"
                    + "<CsScore>\n"
                    + "f 1 0 16384 10 1\n"
                    + "i 1 0 30\n"
                    + "e\n"
                    + "\n"
                    + "</CsScore>\n"
                    + "</CsoundSynthesizer>";
            System.out.println(orc);

            Writer writer = null;
            String file = "testeDistortion.csd";
            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file), "utf-8"));
                writer.write(orc);
            } catch (IOException ex) {
                // report
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {/*ignore*/
                }
            }

            System.out.println(orc);
            final Csound c = new Csound();

            c.Compile(file);
            c.Start();
            c.Perform();
            c.Stop();
        }
    }

}
