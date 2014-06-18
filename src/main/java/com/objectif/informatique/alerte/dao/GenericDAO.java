package com.objectif.informatique.alerte.dao;

import java.util.List;

public interface GenericDAO <TYPE, KEY>{

	List<TYPE> findAll();

	TYPE create(TYPE object);

	TYPE update(TYPE object);

	TYPE find(KEY id);
	boolean delete(KEY id);
}
