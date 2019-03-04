import java.util.LinkedList;

public abstract class AlgoritmoSubstituicao {
	protected int falhas;
	protected int Nquadros;
	protected int acertos;
	LinkedList quadros;
	
	public AlgoritmoSubstituicao(){
		
	}
	
	public AlgoritmoSubstituicao(int Nquadros){		
		this.Nquadros = Nquadros;
		falhas = 0;
		acertos = 0;
	}

	public int getFalhas() {
		return falhas;
	}

	public void setFalhas(int falhas) {
		this.falhas = falhas;
	}

	public int getQuadros() {
		return Nquadros;
	}

	public void setNquadros(int Nquadros) {
		this.Nquadros = Nquadros;
	}
	
	//Retorna o número de falhas
	public int getContaFalhas(){
		return falhas;
	}
	
	public int getContaAcertos(){
		return acertos;
	}
	
	//Insere páginas
	//É abstrata pois os algoritmos redefinirão este método em suas
	//respectivas classes.
	public abstract void inserir(int number);
	
	//Imprime os quadros
	public void imprimirQuadros(){
		System.out.println("Quadros: ");
		for(int i=0; i<quadros.size(); i++){
			System.out.println(quadros.get(i)+" ");
		}
	}
	
	
	
}
