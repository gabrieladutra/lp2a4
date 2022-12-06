package lp2a4;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import lp2a4.modelo.AlunoPOJO;
import lp2a4.modelo.Disciplina;

public class Aplicacao {
	
	public static void main(String[] args) {
		AlunoPOJO aluno = new AlunoPOJO();
		aluno.setMatricula("SP12345");
		aluno.setNome("Terezinha de Jesus");
		aluno.setEndereco("Rua das Flores, n 5, Vila Jardim, São Paulo");
		aluno.setDataIngresso(LocalDate.of(2022, 01, 01));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(aluno);
		
		em.getTransaction().commit();
		
		System.out.println("gravado!!");
		
		AlunoPOJO alunoFind = em.find(AlunoPOJO.class, "SP12345");
		
		System.out.println(alunoFind.toString());
		
		
		System.out.println("\n========\nRecuperando a lista\n========\n");
		final String queryAlunos = "select a from AlunoPOJO a order by a.dataIngresso";
		TypedQuery<AlunoPOJO> consultaAlunos = em.createQuery(queryAlunos, AlunoPOJO.class);
		final List<AlunoPOJO> alunos = consultaAlunos.getResultList();
		alunos.forEach( System.out::println );
		System.out.println("\n========\nRecuperando a lista 2\n========\n");
		TypedQuery<AlunoPOJO> consultaAlunos2 = em.createQuery("from AlunoPOJO", AlunoPOJO.class);
		final List<AlunoPOJO> alunos2 = consultaAlunos2.getResultList();
		alunos2.forEach( System.out::println );
		
		System.out.println("\n========\nLista de Disciplinas\n========\n");		
		TypedQuery<Disciplina> consultaDisciplina = em.createQuery("from Disciplina d where d.codigo = 'LP2A4'", Disciplina.class);
		final Disciplina disciplina = consultaDisciplina.getSingleResult();
		disciplina.getAlunos().forEach( System.out::println );
		
		System.out.println("\n========\nLista de Disciplinas com Criteria\n========\n");	
	    CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<Disciplina> criteriaQuery = builder.createQuery(Disciplina.class);
	     
	    Root<Disciplina> veiculo = criteriaQuery.from(Disciplina.class);
	    criteriaQuery.select(veiculo);
	 
	    TypedQuery<Disciplina> query = em.createQuery(criteriaQuery);
	    query.getSingleResult().getAlunos().forEach( System.out::println );
		em.close();
		emf.close();
	}

}
