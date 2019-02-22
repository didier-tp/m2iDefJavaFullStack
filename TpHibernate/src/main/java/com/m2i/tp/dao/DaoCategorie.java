package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Categorie;

// DAO = Data Access Object avec methodes CRUD
// et throws RuntimeException implicite
public interface DaoCategorie {
	public void createCategorie(Categorie p);

	public void updateCategorie(Categorie p);

	public void deleteCategorie(Long numeroCategorie);

	public Categorie categorieByNum(Long numCategorie);

	public List<Categorie> allCategories();
}
