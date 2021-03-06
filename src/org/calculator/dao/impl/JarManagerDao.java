package org.calculator.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.calculator.dao.IJarManagerDao;
import org.calculator.models.JarFileModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see org.calculator.dao.IJarManagerDao
 * 
 * @author khalil.amdouni
 *
 */
@Repository("jarManagerDao")
@Transactional
public class JarManagerDao extends GenericDao<JarFileModel> implements IJarManagerDao {

	private static final Logger logger = Logger.getLogger(JarManagerDao.class);

	
	
	public JarManagerDao() {
		super(JarFileModel.class);
	}

	@Override
	public String saveJar(JarFileModel jarFile) throws IllegalStateException,
			IOException {

		String jarId = UUID.randomUUID().toString();
		File jarLocalFile = new File("/home/khalil/work/spring/jartest/"
				+ jarId + ".jar");
		jarFile.getJarFile().transferTo(jarLocalFile);
		jarFile.setJarId(jarId);
		em.persist(jarFile);
		em.flush();
		logger.info("Object persisted");
		return jarLocalFile.getName();
	}

	@Override
	public List<JarFileModel> getJars(int startIndex, int dataCount) {
		TypedQuery<JarFileModel> query = em.createNamedQuery(
				"JarFileModel.getAllJars", JarFileModel.class);
		
		if (startIndex >= 0 && dataCount > 0) {
			query.setFirstResult(startIndex);
			query.setMaxResults(dataCount);
		}
		return query.getResultList();
	}

	@Override
	public int getJarsCount() {
		return ((Number) em.createNamedQuery("JarFileModel.getJarsCount")
				.getSingleResult()).intValue();
	}

	public List<JarFileModel> getUnreflectedJars() {
		TypedQuery<JarFileModel> query = em.createNamedQuery(
				"JarFileModel.getJars", JarFileModel.class);
		query.setParameter("reflected", false);
		return query.getResultList();
	}

	@Override
	public List<JarFileModel> getReflectedJars() {
		TypedQuery<JarFileModel> query = em.createNamedQuery(
				"JarFileModel.getJars", JarFileModel.class);
		query.setParameter("reflected", true);
		return query.getResultList();
		
	}

}
