package iy.jspspring.training.database.jpa.kernel;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EntityManagerWrapper {
    private EntityManager manager;

    public EntityManagerWrapper() {}

    public EntityManagerWrapper(EntityManager manager) {
        this.manager = manager;
    }

    public EntityManager getManager() {
        return manager;
    }

    @PersistenceContext
    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
