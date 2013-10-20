package org.calculator.business.impl;

import org.calculator.business.IGenericManager;

/**
 * @see org.calculator.business.IGenericManager
 * @author khalil.amdouni
 * 
 * @param <T>
 */
public abstract class GenericManager<T> implements IGenericManager<T> {

	@Override
	public T save(T t) {
		return getDao().save(t);
	}

	@Override
	public T get(Object id) {
		return getDao().getById(id);
	}

	@Override
	public void delete(Object id) {
		getDao().delete(id);
	}

}
