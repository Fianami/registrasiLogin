package com.regis.sandbox.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.regis.sandbox.dao.GenericDao;


public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {

	public static final String PERSISTENCE_UNIT_NAME = "ApplicationEntityManager";
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
    private EntityManager entityManager;
    private Class<T> persistentClass;
	
	public GenericDaoHibernate( Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }
    
	@Override
	public T get(PK id) {
		T entity = this.entityManager.find(this.persistentClass, id);

        if (entity == null) {
            String msg = "Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...";
            log.warn(msg);
            throw new EntityNotFoundException(msg);
        }

        return entity;
	}

	@Override
	@Transactional
	public T save(T model) {
        return this.entityManager.merge(model);
	}

	@Override
	public List<T> getAll() {
		return this.entityManager.createQuery(
                "select obj from " + this.persistentClass.getName() + " obj  ")
                .getResultList();
	}

	@Override
	@Transactional
	public void remove(PK id) {
		T entity = get(id);
        if (entity != null) {
            log.debug("Removing entity " + id.toString());
            this.entityManager.remove(entity);
        }
	}



	
	
	
}
