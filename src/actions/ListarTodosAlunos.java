package actions;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Aluno;

public class ListarTodosAlunos {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Aluno> query = manager.createQuery("select aluno from Aluno aluno", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        for (Aluno aluno : alunos) {
            System.out.println("id: " + aluno.getId());
            System.out.println("nome: "+aluno.getNome());
            System.out.println("email: "+aluno.getEmail());
            System.out.println("cpf: "+aluno.getCpf());
            System.out.println("nascimento: "+aluno.getDataNascimento().getTime());
            System.out.println("naturalidade: "+aluno.getNaturalidade());
            System.out.println("endereco: "+aluno.getEndereco());
            System.out.println();
        }
        manager.close();
        factory.close();
    }
}