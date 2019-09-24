package br.com.diego.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.diego.entity.Planeta;


public class PlanetaRepository {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public PlanetaRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("planeta");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/*
	 * 	Criar resgistros dentro do Banco
	 */
	public void Salvar(Planeta planeta_entity) {

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(planeta_entity);
		this.entityManager.getTransaction().commit();
	}

	/*
	 * 	Buscar todos os registros do Banco
	 */
	@SuppressWarnings("unchecked")
	public List<Planeta> TodosPlanetas() {

		List<Planeta> planetas = this.entityManager.createQuery("From Planeta order by id_planeta asc")
				.getResultList();

		return planetas;
	}

	/*
	 * 	Buscar registros do Banco por ID
	 */
	public Planeta PlanetasId(int id_planeta) {

		Planeta planeta = new Planeta();
		try {
			planeta = this.entityManager.createQuery("From Planeta where id_planeta =:id_planeta", Planeta.class)
					.setParameter("id_planeta", id_planeta).getSingleResult();
			return planeta;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * 	Buscar registros do banco por Nome
	 */
	public Planeta PlanetasNome(String nome) throws Exception {
		
		Planeta planeta = new Planeta();
		try {
			planeta = this.entityManager.createQuery("From Planeta where nome =:nome", Planeta.class)
					.setParameter("nome", nome).getSingleResult();
			return planeta;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/*
	 * 	Excluir registros do Banco
	 */
	public void ExcluirPlaneta(int id) {
		
		Planeta planeta = new Planeta();
		try {
			planeta = this.entityManager.createQuery("From Planeta where id_planeta =:id_planeta", Planeta.class)
					.setParameter("id_planeta", id).getSingleResult();
			
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(planeta);
			this.entityManager.getTransaction().commit();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
