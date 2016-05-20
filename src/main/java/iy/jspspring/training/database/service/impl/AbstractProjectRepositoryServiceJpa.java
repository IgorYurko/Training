package iy.jspspring.training.database.service.impl;

import com.google.common.collect.Lists;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import iy.jspspring.training.database.jpa.kernel.ProjectRepository;
import iy.jspspring.training.database.service.ProjectRepositoryServiceJpa;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Transactional
public abstract class AbstractProjectRepositoryServiceJpa<T extends Serializable, ID extends Serializable>
        implements ProjectRepositoryServiceJpa<T> {
    protected final ProjectRepository<T, ID> repository;
    protected final Class clazz;

    protected AbstractProjectRepositoryServiceJpa(ProjectRepository<T, ID> repository, Class clazz) {
        this.repository = repository;
        this.clazz = clazz;
    }

    protected String getClazz() {
        return clazz.getName();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        List<T> each = new ArrayList<>();
        repository.getCrudOperations().findAll().forEach(each::add);
        return each;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> findAll1() {
        return repository.getCurrentSession().createQuery("from " + getClazz()).list();
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> findAll2() {
        return repository.getEntityManager().createQuery("from " + getClazz()).getResultList();
    }
}
