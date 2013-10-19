package org.calculator.dao;


/**
 * Generic DAO interface
 * 
 * @author khalil.amdouni
 * 
 * @param <T>, represents the entity type
 */
public interface IGenericDao<T> {
	public T save(T t);

	public T getById(Object id);

	public void delete(Object id);

}
