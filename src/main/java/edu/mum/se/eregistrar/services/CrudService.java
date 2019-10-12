package edu.mum.se.eregistrar.services;

import org.springframework.data.domain.Page;

/**
 * Created by Jonathan on 10/9/2019.
 */

public interface CrudService<T, ID> {
	Page<T> findAll(int pageNo);
	T findById(ID id);
	T create(T t);
	T update(T t, ID id);
	void deleteById(ID id);
}
