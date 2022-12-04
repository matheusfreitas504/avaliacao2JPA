package actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Aluno;

public class AtualizarAluano {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        System.out.println("digite o id que deseja atualizar: ");
        Aluno aluno1 = manager.find(Aluno.class, input.nextLong());
        System.out.println("digite o nome do aluno: ");
        input.nextLine();
        aluno1.setNome(input.nextLine());
        System.out.println("digite o email do aluno: ");
        aluno1.setEmail(input.nextLine());
        System.out.println("digite o cpf do aluno: ");
        aluno1.setCpf(input.nextLine());
        System.out.println("digite a data de nascimento do aluno: ");
        String dataNascimento = input.nextLine();              
		try {
			DateFormat df = new SimpleDateFormat("dd/mm/yyyy");  
			Date data;
			data = df.parse(dataNascimento);
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
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
