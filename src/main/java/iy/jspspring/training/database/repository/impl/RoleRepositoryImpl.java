package iy.jspspring.training.database.repository.impl;

import iy.jspspring.training.database.jpa.kernel.AbstractProjectRepository;
import iy.jspspring.training.database.jpa.kernel.EntityManagerWrapper;
import iy.jspspring.training.database.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepo")
public class RoleRepositoryImpl extends AbstractProjectRepository<Role, Integer>
{
    @Autowired
    protected RoleRepositoryImpl(CrudRepository<Role, Integer> crudOperations, EntityManagerWrapper wrapper)
    {
        super(crudOperations, wrapper);
    }
}
