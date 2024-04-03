import java.util.ArrayList;

public class Plantel  {
	
	private ArrayList<Atleta> atle;


	public Plantel(){
		atle = new ArrayList<>();
	}

	public boolean cadastraAtleta(Atleta atleta) {
		return atle.add(atleta); 
        
    }


	
	public Atleta consultaAtleta(String nome) {
		for (Atleta atleta : this.atle) {
			if (atleta.getNome().equalsIgnoreCase(nome)){
				return atleta;
			}
		}
		return null;
	}

	public Atleta consultaAtleta(int numero) {
		for (Atleta atleta : this.atle) {
			if (atleta.getNumero() == (numero)){
				return atleta;
			}
			
		}
		return null;
	}

	public Atleta consultaAtletaComMaisMedalhas(){
        if (atle.size() > 0) {
            Atleta atleta = this.atle.get(0);
            for(Atleta at: this.atle) {
                if (at.consultaQuantidadeMedalhas() > atleta.consultaQuantidadeMedalhas())
                    atleta = at;
            }
            return atleta;
        }
        return null;
    }
	
	public ArrayList<Atleta> mostrarAtletaPorPais(String pais) {
        ArrayList<Atleta> listaAtletas = new ArrayList<>();
        for(Atleta a: this.atle) {
            if (a.getPais().equalsIgnoreCase(pais))
                listaAtletas.add(a);
        }
        return listaAtletas;
    }

	
    



	

	

}
