package iy.jspspring.training.database.jpa.kernel;

import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public interface ProjectRepository<T, ID extends Serializable>
{
    CrudRepository<T, ID> getCrudOperations();
    EntityManager getEntityManager();
    Session getCurrentSession();
}
