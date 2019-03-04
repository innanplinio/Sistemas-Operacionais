/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Innan
 */
public interface Buffer {

    public void set(Tarefa t, int idP) throws InterruptedException;

    public Tarefa get(int idC) throws InterruptedException;
}
