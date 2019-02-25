package com.m2i.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.entity.Client;

@Repository
@Transactional
public class DaoClientJpa implements DaoClient {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client findById(Long num) {
		return entityManager.find(Client.class, num);
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
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
