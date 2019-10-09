package edu.mum.se.eregistrar.services;

import java.util.List;

/**
 * Created by Jonathan on 10/9/2019.
 */

public interface CrudService<T, ID> {
	List<T> findAll();
	T findById(ID id);
}
