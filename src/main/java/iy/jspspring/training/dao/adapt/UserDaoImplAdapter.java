package iy.jspspring.training.dao.adapt;

import iy.jspspring.training.dao.intrf.UserDao;
import iy.jspspring.training.database.entity.User;

import java.util.List;

public abstract class UserDaoImplAdapter extends AbstractOperationsDao<User> implements UserDao
{

    public UserDaoImplAdapter()
    {
        setaClass(User.class);
    }

    @Override
    public User findByName(String name)
    {
        return null;
    }

    @Override
    public List<User> findAllByName(String name)
    {
        return null;
    }

}
