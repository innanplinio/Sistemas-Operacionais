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
	
	//Retorna o n�mero de falhas
	public int getContaFalhas(){
		return falhas;
	}
	
	public int getContaAcertos(){
		return acertos;
	}
	
	//Insere p�ginas
	//� abstrata pois os algoritmos redefinir�o este m�todo em suas
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
