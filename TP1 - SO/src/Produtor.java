/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Innan
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtor implements Runnable {

    public static int idP = 0;    
    private final Buffer buffer;
    private int contador;//Conta quantas tarefas já foram lidas do arquivo
    private int total_linhas;//Linhas do arquivo
    private String arqv;//Armazena o nome do arquivo referente a este produtor

    public Produtor(Buffer buffer, String arqv) {
        this.arqv = arqv;
        this.buffer = buffer;
    }

    public void run() {
        idP++;
        do {
            try {
                //Lendo uma linha do arquivo e alocando a uma tarefa
                Scanner scanner = new Scanner(new FileReader(arqv+".txt")).useDelimiter("\\||\\n");
                while (scanner.hasNext()) {//Lendo as tarefas do arquivo e encapsulando em um tipo tarefa
                    Tarefa t = new Tarefa();
                    t.setNome(scanner.next());
                    String d = scanner.next();
                    String aux = d.replaceAll("\\D", "");
                    t.setDuracao(Integer.parseInt(aux));
                    contador++;
                    total_linhas = ContaLinhasArquivo();
                    buffer.set(t, idP);//Inserindo a tarefa no buffer

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (total_linhas < contador);//Executa a thread até o contador ser igual ao numero de tarefas no arquivo
        System.out.println("Produtor[" + Thread.currentThread().getId() + "] encerrando...");

    }
    
    //Método para contar linhas do arquivo
    public int ContaLinhasArquivo() throws FileNotFoundException {
        LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream("C:\\Users\\Innan\\Documents\\NetBeansProjects\\TP1\\src\\tp1\\tarefa.txt")));
        String nextLine = null;
        try {
            while ((nextLine = lineCounter.readLine()) != null) {
                if (nextLine == null) {
                    break;
                }
            }
        } catch (Exception done) {
            done.printStackTrace();
        }
        return lineCounter.getLineNumber();
    }    

}
