package actions;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int x = 0;
		Scanner input = new Scanner(System.in);
		int numero = 0;
		do {
			System.out.println(
					"1- Inserir \n2- Consultar Lista Completa \n3- Consultar Lista Por Letra\n4- Editar\n5- Deletar\n6- Sair\n");
			System.out.println("digite a opcao desejada: ");
			numero = input.nextInt();
			while (numero > 6 || numero < 1) {
				System.out.println("digite a opcao desejada: ");
				numero = input.nextInt();
				if (numero > 6 || numero < 1) {
					System.out.println("numero invalido, digite um numero de 1 a 6\n");
				}
			}
			switch (numero) {
			case 1: {	
				InserirAluno.main(args);
			}
				break;
			case 2: {
				ListarTodosAlunos.main(args);
			}
				break;
			case 3: {
				ListarInicial.main(args);
			}	
				break;
			case 4:{
				AtualizarAluano.main(args);
			}	
				break;
			case 5:{
				RemoverAluno.main(args);
			}	
				break;
			case 6:
				System.out.println("Saindo...");
			}
			System.out.println("deseja continuar? 1 - sim  2 - nao");
			x = input.nextInt();	
			input.nextLine();

		} while (x != 2);
	}
}
	
