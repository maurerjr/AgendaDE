import java.util.ArrayList;
import java.util.Scanner;

public class Contato {

    public String nome;
    public String sobrenome;
    public String email;
    public String endereco;
	ArrayList<String> telefone = new ArrayList<>();

    
    
    Contato proximo;
    Contato anterior;


    public void ler(){
    	Scanner tc = new Scanner(System.in);
    	String repetido;
    	ListaDuplamente nomeUnico = new ListaDuplamente();

    	do{
    	System.out.println("\n Digite o primeiro nome");
    	nome = tc.next();
    	System.out.println("\n Digite o sobrenome");
    	sobrenome = tc.next();
    	repetido=nomeUnico.nomeUnico(sobrenome, nome);
    	}while(repetido=="repetido");
    	System.out.println(repetido);
    	System.out.println("\n Digite o email");
    	email = tc.next();
    	System.out.println("\n Digite o endereco");
    	endereco = tc.next();
    	
    	
    	System.out.println("\n Digite o telefone");
    	//String tel = tc.next();
    	int op;
    	telefone.add(tc.next());
    	do{
    		System.out.println("\n Deseja adicionar outro telefone? 1 - Sim qualquer outro numero pra Nao");
    		op = tc.nextInt();
    		
    			if(op == 1)
    			{
    				System.out.println("\n Digite um novo telefone: ");
    				telefone.add(tc.next());
    			}
    			else{
    				break;
    			}
    	
    		
    	}while(op==1);
    	
    }
    
    public void mostrar(){
    	System.out.println("\n Nome: "+ nome);
		System.out.println("\n Sobrenome: "+ sobrenome);
		System.out.println("\n Endereco: "+ endereco);
		System.out.println("\n Email: "+ email);
		for(int i=0; i<telefone.size();i++)
		{
			System.out.println("telefone: "+ telefone.get(i));
		}
    }
    
    
}
