package es.xoubin.showcase.pool.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import es.xoubin.showcase.pool.dao.CatDao;
import es.xoubin.showcase.pool.entity.Cat;

@Service("catDao")
public class CatDaoImpl implements CatDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Cat> getAllCats() {
		Query query = em.createQuery("SELECT c from Cat as c");
        return query.getResultList();
	}

}