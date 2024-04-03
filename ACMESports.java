import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class ACMESports {
   private Scanner entrada = null;
   private PrintStream streamSaida;  
   private final String nomeArquivoEntrada = "dadosin.txt";  
   private final String nomeArquivoSaida = "dadosout.txt";  

    private Medalheiro medalheiro = new Medalheiro();
    private Plantel plantel = new Plantel();
    

    public ACMESports() {
      try {
        BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
        entrada = new Scanner(streamEntrada);   
        streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
        System.setOut(streamSaida);  

    } catch (Exception e) {
        System.out.println(e);

    }

    Locale.setDefault(Locale.ENGLISH);   
    entrada.useLocale(Locale.ENGLISH);
       
 
     }
     
    
     //ira ser executado no main
    public void executar() {
     
      LerDadosDoAtleta();
      LerDadosDaMedalha();
      LerMedalhasParaAtletas();
      consultaAtletaNumero();
      consultaAtletaNome();
      mostrarDadosMedalha();
      mostrarAtletaPorPais();
      mostrarAtletaPorTipoMedalha();
      dadosPorDoAtletaModalidade();
      consultaAtletaComMaisMedalhas();
    } 


    //lera os dados do atleta a cadastrar
    public void LerDadosDoAtleta(){
      int numero;
      String nome;
      String pais;
      Atleta atle;

      numero = Integer.parseInt(entrada.nextLine());
      
      while (numero != -1) {
        nome = entrada.nextLine();
        pais = entrada.nextLine();
        atle = new Atleta(numero, nome, pais);
        plantel.cadastraAtleta(atle);
        streamSaida.println("Nome: " +  atle.getNome()+ " ,Pais: "+ atle.getPais() + ",Numero: " + atle.getNumero());
        numero = Integer.parseInt(entrada.nextLine()); 
      }
    }


    //lera os dados da medalha e ira cadastrar
    public void LerDadosDaMedalha(){
      String modalidade;
      int cod;
      int tipo;
      boolean individual;
      Medalha med;

      cod = Integer.parseInt(entrada.nextLine());
      while (cod != -1) {
        tipo = Integer.parseInt(entrada.nextLine());
        individual =Boolean.parseBoolean(entrada.nextLine());
        modalidade = entrada.nextLine();

        med = new Medalha(cod, tipo, individual, modalidade);
        medalheiro.cadastraMedalha(med);
        streamSaida.println("Codigo: " + med.getCodigo() + ",Tipo:  " + med.getTipo() + "  ," + med.getIndividual() + ",Modalidade:     " + med.getModalidade()+".");
        cod= Integer.parseInt(entrada.nextLine());   
      }
    } 


    //ira mostrar os atletas e seus respectivos paises cadastrados 
    public void mostrarAtletaPorPais(){
      String pais = entrada.nextLine();
        ArrayList<Atleta> atletas = plantel.mostrarAtletaPorPais(pais);

        if (atletas.size() > 0){
            for (Atleta atleta : atletas) {
                streamSaida.println("Numero:   "+atleta.getNumero()+",Nome:   "+atleta.getNome()+",Atleta    "+atleta.getPais()+".");
            }
        } else {
            streamSaida.println("Pais nao encontrado!!!");
        }
    } 



    //mostrara a medalha associada ao atleta pelo tipo
    public void mostrarAtletaPorTipoMedalha(){
      int tipo = Integer.parseInt(entrada.nextLine());
      ArrayList<Atleta> ate = medalheiro.mostrarAtletaPorTipoMedalha(tipo);
      
      if(ate.size() > 0 ){
       for (Atleta atleta : ate) {
        streamSaida.println( "Numero do atleta: " + atleta.getNumero()+ ", Nome: :"+ atleta.getNome()+ ",  País: " + atleta.getPais() + " ");
      }
      }else{
        streamSaida.println("Nenhum atleta encontrado!!!");
        
       }
        
    }
    

    // mostrara a modalidade que o atleta faz e a qual e faz
    public void dadosPorDoAtletaModalidade(){
      String modalidade = entrada.nextLine();
      Medalha medalha = medalheiro.consultaMedalhasModalidade(modalidade);
      
      if (medalha == null) {
          streamSaida.println("Modalidade não encontrada!!");
        }else{
          if(medalha.getAtletas().size()<=0){
            streamSaida.println("Modalidade:" + medalha.getModalidade()+ ",Tipo:  " + medalha.getTipo()+ ", Sem atletas com a Medalha!!!");
          }else{
            for (Atleta  atleta : medalha.getAtletas()) {
              streamSaida.println("Modalidade:" + medalha.getModalidade()+ ",Tipo:  " + medalha.getTipo()+ ", Numero do Atleta: " + atleta.getNumero() + ",  Nome do atleta:" + atleta.getNome()+" ," + " País: " + atleta.getPais());
            }
          }
        }
      }



      // mostrara o número do associado
      public void consultaAtletaNumero(){
        int numero = Integer.parseInt(entrada.nextLine());
        Atleta at = plantel.consultaAtleta(numero);

        if (at !=null) {
          streamSaida.println( "Numero do atleta:" + at.getNumero()+ " ,Nome: "+ at.getNome()+ ", País:  " + at.getPais() + " ");          
        }else{
          streamSaida.println("Nenhum atleta encontrado!!!");	
        }

      }

      // mostrara o nome do associado
      public void consultaAtletaNome(){
        String nome= entrada.nextLine();
        Atleta at = plantel.consultaAtleta(nome);
        if (at!=null) {
          streamSaida.println( "Numero do atleta: " + at.getNumero()+ " ,Nome: "+ at.getNome()+ ",  País: " + at.getPais() + " ");          
        }else{
          streamSaida.println("Nenhum atleta encontrado!!!");	
        }

      }

      // mostrara o atleta com mais medalha e seus dados
      public void consultaAtletaComMaisMedalhas(){
        Atleta at = plantel.consultaAtletaComMaisMedalhas();
        if (at == null) {
          streamSaida.println("Nenhum atleta com medalha!!!");
        }else{
          streamSaida.println("Numero do atleta: " + at.getNumero()+ ", Nome: "+ at.getNome()+ ",  País: " + at.getPais() + "  "+",Ouro:"+at.quantidadeDeMedalhas(1)+",Prata:"+at.quantidadeDeMedalhas(2)+",Bronze:"+at.quantidadeDeMedalhas(3)+".");
        }
      }


      

      
      //ira a associar a medalha ao atleta 
      public void LerMedalhasParaAtletas(){
        int codigo;
        int numero;
        Medalha m;
        Atleta a;

        codigo = Integer.parseInt(entrada.nextLine());
        while (codigo != -1) {
          numero = Integer.parseInt(entrada.nextLine());
          m= medalheiro.consultaMedalhaCodigo(codigo);
          a = plantel.consultaAtleta(numero);
          m.adicionaAtleta(a);
          a.adicionaMedalha(m);
          streamSaida.println("Codigo:" + m.getCodigo() + "Numero do Atleta: " + a.getNumero());
          codigo = Integer.parseInt(entrada.nextLine());

        }

      }

      // mostrar se encontrou alguma medalha
      public void mostrarDadosMedalha() {
        int codigo = Integer.parseInt(entrada.nextLine());
        Medalha medalha = medalheiro.consultaMedalhaCodigo(codigo);

        if (medalha != null) {
            streamSaida.println("Codigo: "+medalha.getCodigo()+", Tipo:"+medalha.getTipo()+" , "+medalha.getIndividual()+",  Modalidade:"+medalha.getModalidade()+".");
        } else {
            streamSaida.println("Nenhuma medalha encontrada!!!");
        }

    }


}

   
  


    
