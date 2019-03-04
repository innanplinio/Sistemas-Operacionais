import java.util.LinkedList;

public class Lru extends AlgoritmoSubstituicao {
	public Lru(int n){
		super(n);
		this.quadros = new LinkedList();
	}
	
	public void inserir(int number){
		int tmp = quadros.indexOf(number);		
		if(tmp == -1){			
			if(quadros.size() < Nquadros){
				quadros.add(number);
			}
			else{
				quadros.remove(0);//Remove sempre da primeira posição
								  //pois é sempre este que será o
								  //menos recentemente usado.
				quadros.add(number);
			}
			falhas++;
		}
		else{
			quadros.remove(tmp);
			quadros.add(number);
		}		
	}
}
