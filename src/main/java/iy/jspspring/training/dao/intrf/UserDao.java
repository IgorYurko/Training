package iy.jspspring.training.dao.intrf;

import iy.jspspring.training.database.entity.User;

import java.util.List;

public interface UserDao extends OperationsDao<User>
{
    User findByName(String name);
    List<User> findAllByName(String name);
}
