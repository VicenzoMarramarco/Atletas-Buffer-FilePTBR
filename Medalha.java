import java.util.ArrayList;

public class Medalha {

	private int codigo;
	private int tipo;
	private boolean individual;
	private String modalidade;
	private ArrayList<Atleta> ate;

	public Medalha(int codigo, int tipo, boolean individual, String modalidade){
		this.codigo=codigo;
		this.individual=individual;
		this.modalidade=modalidade;
		this.tipo=tipo;
		ate = new ArrayList<>();
	}
	
	
	public int getCodigo() {return codigo;}
	public int getTipo() {return tipo;}
	public boolean getIndividual() {return individual;}
    public String getModalidade() {return modalidade;}
	
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public void setAte(ArrayList<Atleta> ate) {
		this.ate = ate;
	}

	public void adicionaAtleta( Atleta atleta) {
		System.out.println(atleta.getNumero() + " " + codigo + " ");
		ate.add(atleta);
	} 



	public ArrayList<Atleta> getAtletas(){
		return this.ate;
	}


	
}