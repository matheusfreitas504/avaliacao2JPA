package actions;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Aluno;

public class RemoverAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        Scanner input = new Scanner(System.in);
        System.out.println("Qual ID deseja deletar? ");
        Long id = input.nextLong();
        Aluno aluno = manager.find(Aluno.class, id);
        manager.getTransaction().begin();
        manager.remove(aluno);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}