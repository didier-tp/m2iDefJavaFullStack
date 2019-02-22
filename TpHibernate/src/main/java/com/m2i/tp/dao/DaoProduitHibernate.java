package com.m2i.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.m2i.tp.entity.Categorie;
import com.m2i.tp.entity.Produit;

public class DaoProduitHibernate implements DaoProduit {

	// EntityManager est l'interface fondamentale de JPA
	// dont une implémentation est fournie par Hibernate
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void createProduit(Produit p) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(p); // insert into et auto_increment
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduit(Produit p) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(p); // update sql
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduit(Long numeroProduit) {
		try {
			entityManager.getTransaction().begin();
			Produit p = entityManager.find(Produit.class, numeroProduit);
			entityManager.remove(p); // delete sql
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Produit produitByNum(Long numProduit) {
		return entityManager.find(Produit.class, numProduit);
		// NB la methode .find() retourne null si rien n'est trouvé
	}

	@Override
	public List<Produit> allProduits() {
		return entityManager.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
	}

	@Override
	public List<Produit> produitsByCategorieId(Long idCategorie) {
		Categorie c = entityManager.find(Categorie.class, idCategorie);
		entityManager.refresh(c); // rafraîchir les valeurs de l'objet categorie c
									// en mémoire en fonction des valeurs en base.
		return c.getProduits();// exploiter le lien @OneToMany
	}

	@Override
	public List<Produit> produitsByCategorieName(String categorieName) {
		// TODO Auto-generated method stub
		return null;
	}

}
