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
        c.Compile("teste.csd");

        // This call runs Csound to completion
        c.Perform();

        // At this point, Csound is already stopped, but this call is here
        // as it is something that you would generally call in real-world 
        // contexts
        c.Stop();

    }

}
