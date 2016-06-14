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
   
    
    public void mostrar(){
    	if(inicio!=null)
    		inicio.mostrar();
    	else
    		System.out.println("\n Negocio Vazio");
    	
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
                	
                	int m = vet[l].nome.compareTo(vet[l+1].nome.concat(vet[l+1].sobrenome));
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
    
    
    
    public boolean addMeio(Contato c, int p){
    	Contato novo = c;
    	Contato aux = this.inicio;
		
		if(p==0){
			this.addInicio(c);
		}
		else if(p==(qtd-1)){
			this.addFim(c);
		}
		else if(p<qtd){
			this.addInicio(c);
			System.out.println("Posição não existente, foi adicionado no inicio");
		}else{
			for (int i=0; i<p; i++){
				aux = aux.proximo;
			}
			novo.anterior = aux.anterior;
			novo.proximo = aux;
			aux.anterior = novo;
		}
		return false;
	}
    
    public boolean removeInicio(){
		if(this.inicio == null){
			System.out.println("Lista Vazia");
		}else{
			this.inicio = this.inicio.proximo;
			qtd--;
		}
		
		return false;
	}
	
	public boolean removeFim(){
		if(this.inicio == null){
			System.out.println("Lista Vazia");
		}if (this.inicio==this.fim){
			this.inicio=null;
			this.fim=null;
			qtd--;
		}else{
			Contato aux, pen;
			aux=this.inicio;
			pen=aux;
			while(aux!=null){
				pen = aux;
				aux = pen.proximo;
			}
			pen.proximo=null;
			this.fim = pen;
			qtd--;
		}
		
		return false;
	}
	
	public boolean listaAsc(){
		
		return false;
	}
	
	public boolean listaDesc(){
		return false;
	}
	
	public boolean removeMeio(int p){
		Contato aux = this.inicio;
		Contato anterior = null;
		
		if(p==0){
			this.removeInicio();
			}
		else if(p==(qtd-1)){
			this.removeFim();
		}else{
			for(int i=0; i<p; i ++){
				anterior = aux;
				aux = aux.proximo;
			}
			qtd--;
		}
		
		return false;
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