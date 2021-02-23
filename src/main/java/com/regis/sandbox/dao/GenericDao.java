package com.regis.sandbox.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	
	T get(PK id);
	
	T save(T model);
	
	List<T> getAll();
	
	void remove(PK id);

}
