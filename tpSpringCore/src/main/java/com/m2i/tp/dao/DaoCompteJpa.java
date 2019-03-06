package com.m2i.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.entity.Compte;

@Component
//@Transactional(propagation=Propagation.REQUIRED)  par défaut
@Transactional //pour commit/rollback automatiques
public class DaoCompteJpa implements DaoCompte {
	
	@PersistenceContext // pour initialisation via config Spring 
	                    // et/ou META-INF/persistence.xml
	private EntityManager entityManager;

	@Override
	public Compte save(Compte cpt) {
		if(cpt.getNumero()==null)
			entityManager.persist(cpt);
		else
			entityManager.merge(cpt);
		return cpt;
	}

	@Override
	public Compte findById(Long numero) {
		return entityManager.find(Compte.class, numero);
	}

	@Override
	public List<Compte> findAll() {
		return entityManager.createQuery("SELECT c FROM Compte", Compte.class)
				.getResultList();
	}

	@Override
	public void deleteById(Long numero) {
		entityManager.remove(entityManager.find(Compte.class, numero));

	}

}
