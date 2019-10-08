package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Client;

public interface ClientDao {
	
	public Client findById(Long num);
	public List<Client> findAll();
	//public Optional<Client> findById(Long num);
	public  Client  save(Client client);//au sens save or update
	                                    //en retour: avec clef primaire quelquefois auto_incr
	void deleteById(Long num);
	//...

}
