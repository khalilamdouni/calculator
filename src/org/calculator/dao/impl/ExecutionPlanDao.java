package org.calculator.dao.impl;

import java.util.List;

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
public class ExecutionPlanDao extends GenericDao<ExecutionPlan> implements IExecutionPlanDao {

	public ExecutionPlanDao() {
		super(ExecutionPlan.class);
	}

	@Override
	public List<ExecutionPlan> getExecutionPlans() {

		TypedQuery<ExecutionPlan> query = em.createNamedQuery(
				"ExecutionPlan.getExecutionPlans", ExecutionPlan.class);
		return query.getResultList();
	}

}
