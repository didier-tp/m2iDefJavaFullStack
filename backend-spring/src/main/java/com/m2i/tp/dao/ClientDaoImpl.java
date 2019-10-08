package com.m2i.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.m2i.tp.entity.Client;

/*
 * DAO = Data Access Object (Data Service , Repository , ...)
 * avec méthodes CRUD 
 * ici codé/implémenté avec JPA/Hibernate intégré dans Spring
 */
//il faut mettre @Component ou bien @Repository pour ce cette classe soit prise en charge par Spring

//@Component
@Repository  //@Repository hérite de @Component
//id par defaut = "clientDaoImpl"
@Transactional //pour demander commit/rollback automatiques gérés par Spring ou ...
public class ClientDaoImpl implements ClientDao {
	
	@PersistenceContext //de JPA/EJB et maintenant compatible JPA/Spring
	//configuré avec META-INF/persistence.xml ou un équivalent Spring
	private EntityManager entityManager;

	@Override
	public Client findById(Long num) {
		return entityManager.find(Client.class,num);
	}

	@Override
	public List<Client> findAll() {
		return entityManager.createQuery("SELECT c FROM Client c", Client.class)
				            .getResultList();
	}

	@Override
	public Client save(Client client) {
		if(client.getNumero()==null)
			entityManager.persist(client); //INSERT INTO avec quelquefois auto_incr
		else
			client = entityManager.merge(client);//UPDATE
		return client;
	}

	@Override
	public void deleteById(Long num) {
		Client cli = entityManager.find(Client.class, num);
        entityManager.remove(cli);
	}

}
