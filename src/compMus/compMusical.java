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

    public compMusical() {
        csnd6.csoundInitialize(csnd6.CSOUNDINIT_NO_ATEXIT | csnd6.CSOUNDINIT_NO_SIGNAL_HANDLER);

//        if (efeito.equals("Flanger")) {
        if (true) {
//            c.Compile("flanger.csd");

            final String orc = "<CsoundSynthesizer>\n"
                    + "<CsOptions>\n"
                    + "; Select audio/midi flags here according to platform\n"
                    + "-odac     ;;;RT audio out\n"
                    + ";-iadc    ;;;uncomment -iadc if RT audio input is needed too\n"
                    + "; For Non-realtime ouput leave only the line below:\n"
                    + "; -o distort.wav -W ;;; for file output any platform\n"
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
                    + "asnd   diskin2 \"beats.wav\", 1, 0, 1\n"
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

            Writer writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("f.csd"), "utf-8"));
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
//            c.SetOption("-odac");
//
//            c.InputMessage("i 1 0 10 .2\n"
//                    + "i 1 11 10 .8\n"
//                    + "e");
//            //c.SetOption("-o distort.wav -W");
//            c.CompileOrc(orc);

//            System.out.println(c.GetOutputName());
            c.Compile("f.csd");
            c.Start();
            c.Perform();

//            final CsoundPerformanceThread pt = new CsoundPerformanceThread(c);
//            pt.Play();
//                button.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        pt.InputMessage("i1 0 2 .5 400 .25");
//                    }
//                });
//                frame.addWindowListener(new WindowAdapter() {
//                    @Override
//                    public void windowClosing(WindowEvent e) {
//                        pt.Stop();
//                        pt.Join();
//                        c1.Stop();
//                    }
//                });
//                frame.getContentPane().add(button);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//            pt.Stop();
//            pt.Join();
            c.Stop();
//                    
//            c.Perform();
//
//            c.Stop();
        }
    }

    public static void main(String args[]) {
        new compMusical();
    }

}
