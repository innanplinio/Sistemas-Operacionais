import java.util.LinkedList;

public class Fifo extends AlgoritmoSubstituicao {
	private int io = 0;
	
	//Construtor recebe a quantidade de quadros e
	//instancia a LinkedList
	public Fifo(int n){
		super(n);
		this.quadros = new LinkedList();
	}
	
	public void inserir(int number){
		//Verifica se a p�gina j� est� na lista antes de inserir
		if(!quadros.contains(number)){
			//Verifica se ainda h� espa�o dispon�vel na mem�ria
			//Se houver, insere a p�gina
			if(quadros.size() < Nquadros){
				quadros.add(number);				
			}
			//Se n�o h� quadro livre, retira um elemento
			//para que este novo seja alocado na mesma posi��o
			//do elemento que foi retirado
			else{
				quadros.remove(io);
				quadros.add(io, number);
				io++;//Passa para pr�xima posi��o para inser��o/retirada
				if(io == Nquadros){
					io = 0;//Quando o io for igual ao "tamanho dos quadros",
						   //retorna a primeira posi��o da lista
				}
			}
			falhas++;//Incrementa o n�mero de falhas
		}
		else{
			acertos++;
		}
	}
	
}
