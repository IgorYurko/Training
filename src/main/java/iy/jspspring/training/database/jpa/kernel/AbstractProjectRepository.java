package iy.jspspring.training.database.jpa.kernel;

import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class AbstractProjectRepository<T, ID extends Serializable>
        implements ProjectRepository<T, ID> {
    protected final CrudRepository<T, ID> crudOperations;
    protected final EntityManager manager;

    protected AbstractProjectRepository(CrudRepository<T, ID> crudOperations, EntityManagerWrapper wrapper) {
        this.crudOperations = crudOperations;
        this.manager = wrapper.getManager();
    }

    @Override
    public CrudRepository<T, ID> getCrudOperations() {
        return crudOperations;
    }

    @Override
    public EntityManager getEntityManager() {
        return manager;
    }

    @Override
    public Session getCurrentSession() {
        return manager.unwrap(Session.class);
    }
}
