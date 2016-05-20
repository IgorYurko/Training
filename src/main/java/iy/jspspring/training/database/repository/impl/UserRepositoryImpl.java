package iy.jspspring.training.database.repository.impl;

import iy.jspspring.training.database.jpa.kernel.AbstractProjectRepository;
import iy.jspspring.training.database.jpa.kernel.EntityManagerWrapper;
import iy.jspspring.training.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public class UserRepositoryImpl extends AbstractProjectRepository<User, Integer>
{
    @Autowired
    public UserRepositoryImpl(CrudRepository<User, Integer> crudOperations, EntityManagerWrapper wrapper)
    {
        super(crudOperations, wrapper);
    }
}
