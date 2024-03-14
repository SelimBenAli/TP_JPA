package com.selim.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.selim.entities.Velo;
import com.selim.util.JPAutil;


public class VeloDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

	public void ajouter(Velo c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(c);
		tx.commit();
	}

	public void modifier(Velo c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(c);
		tx.commit();
	}

	public void supprimer(Velo c) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		c = entityManager.merge(c); 
		entityManager.remove(c);
		tx.commit();
	}

	public Velo consulter(Velo c, Object id) {
		return entityManager.find(c.getClass(), id);
	}

	public List<Velo> listerTous() {
		List<Velo> Velos = entityManager.createQuery("select c from Velo c").getResultList();

		return Velos;
	}

	public List<Velo> listerParNom(String nom) {
		List<Velo> Velos = entityManager.createQuery("select c from Velo c where c.nom like :pnom")
				.setParameter("pnom", "%" + nom + "%").getResultList();

		return Velos;
	}
}