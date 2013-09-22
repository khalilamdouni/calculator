package org.calculator.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.calculator.dao.IJarManagerDao;
import org.calculator.models.impl.JarFileModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("jarManagerDao")
@Transactional
public class JarManagerDao implements IJarManagerDao {

	private static final Logger logger = Logger.getLogger(JarManagerDao.class);
	
	@PersistenceContext
	private EntityManager em;

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
	public List<JarFileModel> getJars() {
		TypedQuery<JarFileModel> query = em.createNamedQuery(
				"JarFileModel.getJars", JarFileModel.class);
		return query.getResultList();
	}

}
