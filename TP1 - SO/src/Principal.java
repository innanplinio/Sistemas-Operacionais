/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Innan
 */
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {

    public static ExecutorService app;

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        // criando  novo banco de threads com 2 threads
        app = Executors.newCachedThreadPool();
        String arqv;

        //criando o buffer
        CircularBuffer b = new CircularBuffer();

        //Exibindo estado do buffer
        System.out.println("Digite o numero de clientes:");
        int n = in.nextInt();
        in.nextLine();
        //executando tarefas do produtor e consumidor
        for (int i = 1; i <= n; i++) {
            System.out.println("Digite o arquivo:");
            
            arqv = in.nextLine();
            app.execute(new Produtor(b, arqv));
        }

        app.execute(new Consumidor(b));
        app.execute(new Consumidor(b));
        app.execute(new Consumidor(b));
        

        app.shutdown();

    }

}
