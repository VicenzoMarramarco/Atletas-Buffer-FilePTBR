import java.util.ArrayList;
import java.lang.String;

public class Medalheiro {
	private ArrayList<Medalha> med;

	public Medalheiro(){
		
		med = new ArrayList<>();
	}



	public boolean cadastraMedalha(Medalha m) {
		return med.add(m);
		
	}


	public Medalha consultaMedalhaCodigo(int codigo) {
		for (Medalha medalha : med) {
			if(medalha.getCodigo()== (codigo)){
			 return medalha;
			}
		}
		return null;
	}



	public Medalha consultaMedalhasModalidade(String modalidade) {
		for (Medalha medalha : med) {
			if(medalha.getModalidade().equalsIgnoreCase(modalidade)){
				return medalha;
			}
		}
		return null;
	} 


	public ArrayList<Atleta>  mostrarAtletaPorTipoMedalha( int tipo){
	
		ArrayList<Atleta> ate = new ArrayList<>();
            for(Medalha medalha : med){
			if (medalha.getTipo()==(tipo)) {
                ate.addAll(medalha.getAtletas());
              }
			}
			return ate;
        
        
    }

	public ArrayList<Medalha> consultaMedalhas(String modalidade){
        ArrayList<Medalha> lista = new ArrayList<Medalha>();
        for(int i=0;i<med.size();i++){
            if(med.get(i).getModalidade().equalsIgnoreCase(modalidade))
                lista.add(med.get(i));
        }
        return lista;
    }
	


}

