/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Innan
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable {

    public static int idC = 0;
    private final CircularBuffer buffer;    
    

    public Consumidor(CircularBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        idC++;
        while (buffer.VerificaBuffer() >= 0) {
            try {
                buffer.get(idC);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (buffer.VerificaBuffer() == 0 && Thread.activeCount() < 5) {

                break;
            }

        }
        System.out.println("Consumidor[" + Thread.currentThread().getId() + "] encerrando...");

    }
}
