package actions;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;


public class InserirAluno {
    public static void main(String[] args){
        Aluno aluno1 = new Aluno();
 
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        aluno1.setNome(input.nextLine());
        System.out.println("O e-mail: ");
        aluno1.setEmail(input.nextLine());
        System.out.println("O CPF: ");
        aluno1.setCpf(input.nextLine());
        System.out.println("A data de nascimento no formato dd/mm/yyyy: ");
        String dataNascimento = input.nextLine();              
		try {
			DateFormat conversor = new SimpleDateFormat("dd/mm/yyyy");  
			Date data;
			data = conversor.parse(dataNascimento);
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(data);
	        aluno1.setDataNascimento(calendar);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Digite a naturalidade do aluno: ");
        aluno1.setNaturalidade(input.nextLine());
        System.out.println("Digite o endereço do aluno: ");
        aluno1.setEndereco(input.nextLine());
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(aluno1);
        manager.getTransaction().commit();
        manager.close();
        factory.close();

        
        System.out.println("ID do aluno: " + aluno1.getId());
    }
}
