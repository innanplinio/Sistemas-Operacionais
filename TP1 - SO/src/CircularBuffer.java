
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Innan
 */
public class CircularBuffer implements Buffer {

    private Tarefa[] buffer;
    private int occupiedCells = 0;//Numero de posições ocupadas do buffer
    private int writeIndex = 0;//Marca a próxima posição para o Produtor inserir uma tarefa no buffer
    private int readIndex = 0;//Marca a próxima posição para o Consumidor retirar uma tarefa do buffer

    public CircularBuffer() {
        //Pede ao usuário que informe o tamanho do buffer e inicializa o buffer
        System.out.println("Digite o tamanho do buffer: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        buffer = new Tarefa[n];
    }
    
    //Método para inserir uma tarefa no buffer, utilizada pelo produtor
    public synchronized void set(Tarefa t, int idP) throws InterruptedException {
        while (occupiedCells == buffer.length) {//Testa se o buffer está cheio
            System.out.println("Buffer está cheio. Produtor[" + Thread.currentThread().getId() + "] esperando.");
            wait();//espera até que a célula do buffer esteja livre.
        }
        buffer[writeIndex] = t;//insere a tarefa na posição writeIndex do buffer
        writeIndex = (writeIndex + 1) % buffer.length;//Incrementa a posição para inserção
        ++occupiedCells;
        System.out.println("Produtor[" + Thread.currentThread().getId() + "] inseriu: " + t.getNome());
        notifyAll();//Notifica todas as threads
    }
    
    //Método para consumir uma tarefa do buffer, utilizada pelo Consumidor
    public synchronized Tarefa get(int idC) throws InterruptedException {

        while (occupiedCells == 0) {//Testa se o buffer está vazio
            System.out.println("Buffer está vazio. Consumidor[" + Thread.currentThread().getId() + "] esperando.");
            wait(1500);
            break;
        }
        if (buffer[readIndex] == null) {//Testa se a posiçao do buffer está vazia
            throw new InterruptedException();
        }
        Tarefa t = buffer[readIndex];
        buffer[readIndex] = null;//Seta a posição do buffer como null para indicar que está vazia
        readIndex = (readIndex + 1) % buffer.length;
        --occupiedCells;
        System.out.println("Consumidor[" + Thread.currentThread().getId() + "] leu: " + t.getNome());
        notifyAll();//Notifica todas as threads
        return t;

    }
    
    //Método que retorna o tamanho do buffer
    public int VerificaBuffer() {
        return occupiedCells;
    }
}
