/**
 * 
 */
package br.com.ifernandes.dao;

import br.com.ifernandes.domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 */
public class CarroDao implements ICarroDao {
	
	@Override
	public Carro cadastrar(Carro carro) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(carro);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();


		return carro;
	}
}
