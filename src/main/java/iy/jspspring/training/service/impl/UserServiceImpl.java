package iy.jspspring.training.service.impl;

import iy.jspspring.training.dao.intrf.UserDao;
import iy.jspspring.training.database.entity.User;
import iy.jspspring.training.service.intrf.UserService;

import java.util.List;

//@Service
public class UserServiceImpl implements UserService
{
    public UserServiceImpl()
    {
    }

//    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id)
    {
        return userDao.findById(id);
    }

    @Override
    public User getUserById(Integer id, String[] fetchModelEagerLine)
    {
        return userDao.findById(id, fetchModelEagerLine);
    }

    @Override
    public List<User> getAllUsers()
    {
        return userDao.findAll();
    }
}
