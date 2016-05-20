package iy.jspspring.training.dao.adapt;

import iy.jspspring.training.dao.intrf.OperationsDao;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@SuppressWarnings("unchecked")
public abstract class AbstractOperationsDao<T extends Serializable> implements OperationsDao<T> {

    //    @Autowired
//    private SessionFactory sessionFactory;
    private Class aClass;

    protected final Class getaClass() {
        return aClass;
    }

    protected final String getaClassAsString() {
        return aClass.getName();
    }

    protected final void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    protected final Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession()
                .createQuery("from " + getaClassAsString())
                .list();
    }

    @Override
    public T findById(Integer id) {
        return (T) getCurrentSession()
                .createQuery("from " + getaClassAsString() + " t where t.id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public final T findById(Integer id, String[] fetchModelEagerLine) {
        if (fetchModelEagerLine == null){
            return findById(id);
        }
        Criteria criteria = getCurrentSession()
                .createCriteria(getaClass(), "t")
                .add(Restrictions.eq("t.id", id))
                .setMaxResults(1);

        for (String line : fetchModelEagerLine) {
            criteria = criteria.setFetchMode("t." + line, FetchMode.JOIN);
        }

        return (T) criteria.uniqueResult();
    }

}