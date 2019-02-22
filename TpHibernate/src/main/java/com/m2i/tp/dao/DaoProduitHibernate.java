package com.m2i.tp.dao;

import java.util.Collection;
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
		return entityManager.createQuery("SELECT p FROM Produit p",	Produit.class)
				.getResultList();
	}
	
	public static void loadImmediatlyLazyCollection(Collection<?> c) {
		//c.size(); //NB: appeler .size() sur une collection force un parcours interne
		          //pour connaitre la taille
		//ou bien 
		for(Object obj : c) { } //boucle for (à vide) sur une collection
		//pour demander à Jpa/Hibernate
		//une remontée immédiate des éléments d'une sous collection
		//avant qu'il ne soit trop tard (entityManager.close() ou ...)
		// ceci permet d'éviter un LazyInitializationException
	}

	@Override
	public List<Produit> produitsByCategorieId(Long idCategorie) {
	     /*
		 Categorie c = entityManager.find(Categorie.class, idCategorie);
		 entityManager.refresh(c); // rafraîchir les valeurs de l'objet categorie c 
		 // en mémoire en fonction des valeurs en base. 
		 List<Produit> listeProd =c.getProduits();//exploiter le lien @OneToMany
		 loadImmediatlyLazyCollection(listeProd);
		 System.out.println(c.toString());
		 return listeProd;
		*/
		
		return entityManager.createNamedQuery("Produit.produitsByCategorieId", 
				                               Produit.class)
				.setParameter("catId", idCategorie)
				.getResultList();
		
	}

	@Override
	public List<Produit> produitsByCategorieName(String categorieName) {
		return entityManager.createNamedQuery("Produit.produitsByCategorieName", 
				                               Produit.class)
				.setParameter(1, categorieName)
				.getResultList();
	}

}
