package com.m2i.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.m2i.tp.entity.Categorie;

public class DaoCategorieHibernate implements DaoCategorie {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void createCategorie(Categorie c) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(c); // insert into et auto_increment
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void updateCategorie(Categorie c) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(c); // update sql
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategorie(Long numeroCategorie) {
		try {
			entityManager.getTransaction().begin();
			Categorie c = entityManager.find(Categorie.class, numeroCategorie);
			entityManager.remove(c); // delete sql
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Categorie categorieByNum(Long numCategorie) {
		return entityManager.find(Categorie.class, numCategorie);
	}

	@Override
	public List<Categorie> allCategories() {
		return entityManager.createQuery("SELECT c FROM Categorie c", Categorie.class).getResultList();
	}

}
