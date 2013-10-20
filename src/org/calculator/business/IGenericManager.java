package org.calculator.business;

import org.calculator.dao.IGenericDao;

/**
 * The interface of the Generic business manager
 * 
 * @author khalil.amdouni
 *
 * @param <T>
 */
public interface IGenericManager<T> {
	
	public IGenericDao<T> getDao();

	public T save(T t);

	public T get(Object id);

	public void delete(Object id);

}
