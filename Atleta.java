import java.util.ArrayList;

public class Atleta  {

	private int numero;
	private String nome;
	private String pais;
    private ArrayList<Medalha> md;
	

	public Atleta(int numero, String nome, String pais) {
		
		this.numero=numero;
		this.nome=nome;
		this.pais=pais;
		md = new ArrayList<>();
	}

	public void adicionaMedalha(Medalha medalha) {
		md.add(medalha);
	}

	public int consultaQuantidadeMedalhas() {
		return md.size();
	}

	public int getNumero() {return numero;}
	public String getNome() {return nome;}
    public String getPais() {return pais;}
    
		
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setMd(ArrayList<Medalha> md) {
		this.md = md;
	}

	public int quantidadeDeMedalhas(int tipo) {
        int quantidade = 0;
        for (Medalha medalha : md) {
            if (medalha.getTipo() == tipo){
				quantidade++;
			}
               
        }
        return quantidade;

    }

	public ArrayList<Medalha> getMd() {
		return md;
	}
	

	
		
}

