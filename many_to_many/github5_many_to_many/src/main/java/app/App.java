package app;

import java.util.List;

import entities.AlunoDisciplina;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main (String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emfactory.createEntityManager();
		
		List<AlunoDisciplina> alunodisc = em.createQuery("FROM AlunoDisciplina", AlunoDisciplina.class).getResultList();
		System.out.println(alunodisc);
	}
}