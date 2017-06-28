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

public class compMusical {

    public static void main(String[] args) {
        csnd6.csoundInitialize(
                csnd6.CSOUNDINIT_NO_ATEXIT | csnd6.CSOUNDINIT_NO_SIGNAL_HANDLER);

        // Create an instance of the Csound object
        Csound c = new Csound();

        // Compile a pre-defined test1.csd file
        // This path should be modified for your own path on your computer
        c.Compile("flanger.csd");

        // This call runs Csound to completion
        c.Perform();

        // At this point, Csound is already stopped, but this call is here
        // as it is something that you would generally call in real-world 
        // contexts
        c.Stop();

    }
    public compMusical(String arquivo, String efeito) {
//        if (efeito.equals("Distortion")) {
//            
//        } else if (efeito.equals("outro")) {
//
//        }

        csnd6.csoundInitialize(
                csnd6.CSOUNDINIT_NO_ATEXIT | csnd6.CSOUNDINIT_NO_SIGNAL_HANDLER);

        // Create an instance of the Csound object
        Csound c = new Csound();

        // Compile a pre-defined test1.csd file
        // This path should be modified for your own path on your computer
        
        c.Compile("teste.csd");
        
//        
//        String orc = "sr=44100\n"
//                + "ksmps=32\n"
//                + "nchnls=2\n"
//                + "0dbfs=1\n"
//                + "\n"
//                + "instr 1 \n"
//                + "kamp chnget \"amp\"\n"
//                + "kfreq chnget \"freq\"\n"
//                + "printk 0.5, kamp\n"
//                + "printk 0.5, kfreq\n"
//                + "aout vco2 kamp, kfreq\n"
//                + "aout moogladder aout, 2000, 0.25\n"
//                + "outs aout, aout\n"
//                + "endin";
//
//        /* SCORE EXAMPLES */
//
//        // Generate Score 
//        String sco = "i1 0 60\n";
//
//        /* END SCORE EXAMPLES */
//
//        // Create an instance of the Csound object
////        Csound c = new Csound();
//
//        // Using SetOption() to configure Csound
//        // Note: use only one commandline flag at a time 
//        c.SetOption("-odac");
//
//        // Compile the Csound Orchestra string
//        c.CompileOrc(orc);
//
//        // Compile the Csound SCO String
//        c.ReadScore(sco);

        // When compiling from strings, this call is necessary before doing 
        // any performing

        // This call runs Csound to completion
        c.Perform();

        // At this point, Csound is already stopped, but this call is here
        // as it is something that you would generally call in real-world 
        // contexts
        c.Stop();

    }

}
