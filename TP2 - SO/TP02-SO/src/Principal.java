import java.util.Scanner;
import java.util.LinkedList;

public class Principal {
	static int numero;
	public static void main(String[] args) {
		System.out.println("Número de quadros: ");
		Scanner in = new Scanner(System.in);
		numero = in.nextInt();
		String[] stringReferencia;//Este vetor terá a mesma quantidade
								  //quantidade de linhas do arquivo.
		  
		  //FIFO
		  System.out.println("\t\t\tAlgoritmo FIFO\n\n");
		  Fifo f = new Fifo(numero);
		  int fal, ac;//Contar erros e acertos respectivamente
		  int n;//"Página" a ser inserida
		  do{
			  System.out.println("Digite um numero: ");
			  n = in.nextInt();
			  f.inserir(n);
			  f.imprimirQuadros();
		  }while(n!=0);
		  fal = f.getContaFalhas()-1;//Retorna o número de erros menos 1, pois
		  							 //o algoritmo conta o zero para finalizar
		  							 //o algoritmo como um erro.
		  ac = f.getContaAcertos();
		  System.out.println("# Erros: "+fal);//Exibe erros e acertos FIFO
		  
		  
		  //LRU
		  System.out.println("\t\t\tAlgoritmo LRU\n\n");
		  Lru l = new Lru(numero);
		  do{
			  System.out.println("Digite um número: ");
			  n = in.nextInt();
			  l.inserir(n);
			  l.imprimirQuadros();
		  }while(n!=0);
		  fal = l.getContaFalhas()-1;
		  ac = l.getContaAcertos();
		  System.out.println("# Erros: "+fal);//Exibe erros e acertos LRU
	}

}
