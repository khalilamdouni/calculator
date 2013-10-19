package org.calculator.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.calculator.dao.IGenericDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Generic DAO implementation
 * 
 * @author khalil.amdouni
 * 
 * @param <T>, represents the entity type
 */
@Repository(value = "genericDao")
@Transactional
public class GenericDao<T> implements IGenericDao<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	public GenericDao(Class<T> type) {
		this.type = type;
	}

	@Override
	public T save(T t) {
		return em.merge(t);
	}

	@Override
	public T getById(Object id) {
		return em.find(type, id);
	}

	@Override
	public void delete(Object id) {
		em.remove(em.getReference(type, id));

	}

}
