import java.util.Scanner;

public class Main {
	static Scanner tc = new Scanner(System.in);
	static ListaDuplamente lista = new ListaDuplamente();
	static Contato c1 = new Contato();
    
	
	
	
	public static void main(String[] args) {
		

		
		int op = 0;
		do{
		System.out.println("\n Digite o quer fazer: 1 - AddInicio \n 2- AddFim \n 3 - Listar \n 4 - Remover por nome");
		op = tc.nextInt();
		switch(op){
		
		case 1:
		{
			Contato c = new Contato();
			c.ler();
			lista.addInicio(c);
			break;
		}
			
		case 2:
		{
			Contato c = new Contato();
			c.ler();
			lista.addFim(c);
			break;
		}
		
		case 3:
		{
			lista.listar();
			break;
		}
		
		case 4:
		{	
			System.out.println("\n Digite o nome:");
			String nome = tc.next();
			System.out.println("\n Digite o sobrenome: ");
			String sobrenome = tc.next();
			
			lista.removePorNome(nome, sobrenome);
			
			break;
		}
		
		
		
		default:
		{
			break;
		}
	}
		
		
		
		}while(op!=10);
		
		
	}
	
}