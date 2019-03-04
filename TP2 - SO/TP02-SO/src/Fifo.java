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
		//Verifica se a página já está na lista antes de inserir
		if(!quadros.contains(number)){
			//Verifica se ainda há espaço disponível na memória
			//Se houver, insere a página
			if(quadros.size() < Nquadros){
				quadros.add(number);				
			}
			//Se não há quadro livre, retira um elemento
			//para que este novo seja alocado na mesma posição
			//do elemento que foi retirado
			else{
				quadros.remove(io);
				quadros.add(io, number);
				io++;//Passa para próxima posição para inserção/retirada
				if(io == Nquadros){
					io = 0;//Quando o io for igual ao "tamanho dos quadros",
						   //retorna a primeira posição da lista
				}
			}
			falhas++;//Incrementa o número de falhas
		}
		else{
			acertos++;
		}
	}
	
}
