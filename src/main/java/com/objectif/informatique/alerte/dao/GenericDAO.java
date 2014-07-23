package com.objectif.informatique.alerte.dao;


public interface GenericDAO <TYPE>{

	TYPE create(TYPE object);

	TYPE update(TYPE object);

	TYPE find(Object id);
	
	void delete(TYPE object);
}
