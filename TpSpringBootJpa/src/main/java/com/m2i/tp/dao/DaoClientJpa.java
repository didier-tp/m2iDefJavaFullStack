package com.m2i.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.entity.Client;

@Repository // composant spring de type DAO (Data Access Object)
@Transactional // begin() et commit()/rollback() déclenchés automatiquement
public class DaoClientJpa implements DaoClient {
	
	@PersistenceContext //pour initialiser entityManager
	                    //à partir de META-INF/persistence.xml 
	                    //ou d'une config équivalente (ici spring)
	private EntityManager entityManager;

	@Override
	public Client findById(Long num) {
		return entityManager.find(Client.class, num);
	}

	@Override
	public List<Client> findAll() {
		return entityManager
				.createNamedQuery("Client.findAll",Client.class)
				.getResultList();
	}

	@Override
	public void save(Client cli) {
		if(cli.getNumero()==null)
			entityManager.persist(cli);
		else
			entityManager.merge(cli);
	}

	@Override
	public void deleteById(Long numCli) {
		Client cli =  entityManager.find(Client.class, numCli);
		entityManager.remove(cli);
	}

}
