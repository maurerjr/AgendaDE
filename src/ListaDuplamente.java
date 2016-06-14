import java.util.ArrayList;

public class ListaDuplamente {
	Contato inicio;
    Contato fim;
    int qtd;



    
    boolean addInicio(Contato c){
        if(this.inicio ==null){
            this.inicio=c;
            this.fim=c;
            this.qtd++;
            return true;
        }else{
            this.inicio.anterior = c;
            c.proximo = this.inicio;
            this.inicio =c;
            this.qtd++;
            return true;
        }
    }
   
  
    public String nomeUnico(String sobrenome, String nome){
    	String r = "Nao repetido, passou pelo laço";
    	
    	if(Main.lista.inicio == null)
    	{
    		r = "primeiro é nulo"; // string pra saber se o metodo chegava aqui
    	}    	
    	else{
    		Contato aux = Main.lista.inicio;
    		r=aux.nome.concat(aux.sobrenome)+" "+ nome.concat(sobrenome); //mesma coisa, apenas pra saber onde buga
    		r = "nome disponível";
    		while(aux != null){
    			if(aux.nome.concat(aux.sobrenome).equals(nome.concat(sobrenome)))
    			{
    				System.out.println("\n O Nome completo precisa ser única, repita por favor: ");
    				r = "repetido";
    				
    				
    			}
    			aux = aux.proximo;
    		}
    	}
		return r;
		
		
    	
    }
    
    public boolean listar()  {
    	if(this.inicio == null)
    	{
    		System.out.println("A lista esta vazia");
    		return false;
    	}    	
    	else{
    		Contato aux = this.inicio;
    		Contato[] vet = new Contato[qtd];
    		
    		int i = 0;
    		while(aux !=null){
    			
    			vet[i] = aux;
    			i++;
    			
    			aux = aux.proximo;
    		}
    		int troca = 1;
            
            while (troca > 0) {

                troca = 0;


                for (int l = 0; l < vet.length - 1; l++) {
                	
                	int m = vet[l].nome.concat(vet[l].sobrenome).compareTo(vet[l+1].nome.concat(vet[l+1].sobrenome));
                	if (m >0) {
                        aux = vet[l];
                        vet[l] = vet[l + 1];
                        vet[l + 1] = aux;
                        troca++;
                    }
                }
            }
            
            for(int l=0; l<vet.length; l++){
            	System.out.println("\n nome: "+ vet[l].nome + " "+ vet[l].sobrenome + " email: "+ vet[l].email + " endereco: "+ vet[l].endereco);
    			for(int x = 0; x<vet[l].telefone.size();x++){
    				System.out.println("telefone: "+ vet[l].telefone.get(x));
    			}
            }
            return true;
    	}            

    }
    	 
    boolean addFim(Contato c){
        if(this.inicio ==null){
             return addInicio(c);
        }else{
            this.fim.proximo =c;
            c.anterior = this.fim;
            this.fim = c;
            this.qtd++;
            return true;
        }
    }
    
   
	public boolean removePorNome(String nome, String sobrenome)
	{
		if(this.inicio == null)
    	{
    		System.out.println("A lista esta vazia");
    		return false;
    	}
		else
		{	
			Contato aux = this.inicio;
			int i = 0;
			while(aux!=null){
				if(aux.nome.concat(aux.sobrenome).equals(nome.concat(sobrenome))){
					aux.anterior.proximo = aux.proximo;
					aux.proximo.anterior = aux.anterior;
					
					i++;
				}
				aux = aux.proximo;
				
			}
			if(i==0)
			{
				System.out.println("\n Esta combinação de nome nao existe");
				return true;
			}
			else{
				System.out.println("Este nome: "+nome+" "+sobrenome+" foi removido com sucesso");
				qtd--;
			}
			
			return true;
		}
	}


}