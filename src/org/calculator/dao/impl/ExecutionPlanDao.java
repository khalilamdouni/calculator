package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.calculator.dao.IExecutionPlanDao;
import org.calculator.models.ExecutionPlan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see org.calculator.dao.IExecutionPlanDao
 * 
 * @author khalil.amdouni
 *
 */
@Repository(value = "executionPlanDao")
@Transactional
public class ExecutionPlanDao implements IExecutionPlanDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ExecutionPlan> getExecutionPlans() {

		TypedQuery<ExecutionPlan> query = em.createNamedQuery(
				"ExecutionPlan.getExecutionPlans", ExecutionPlan.class);
		return query.getResultList();
	}

	@Override
	public ExecutionPlan getExecutionPlan(long id) {
		TypedQuery<ExecutionPlan> query = em.createNamedQuery(
				"ExecutionPlan.getExecutionPlanById", ExecutionPlan.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public void saveExecutionPlan(ExecutionPlan executionplan) {

		em.merge(executionplan);
	}

	@Override
	public void delete(long id) {

		em.remove(em.find(ExecutionPlan.class, id));
	}

}
