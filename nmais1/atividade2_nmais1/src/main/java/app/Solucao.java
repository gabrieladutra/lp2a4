ackage app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Veiculo;

public class Solucao {

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emFactory.createEntityManager();
		
		List<Veiculo> listaVeic = em.createQuery("FROM Veiculo v join fetch v.proprietario", Veiculo.class).getResultList();
		System.out.println(listaVeic);
	}
}