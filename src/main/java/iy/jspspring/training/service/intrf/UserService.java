package iy.jspspring.training.service.intrf;

import iy.jspspring.training.database.entity.User;

import java.util.List;

public interface UserService
{
    User getUserById(Integer id);
    User getUserById(Integer id, String[] fetchModelEagerLine);
    List<User> getAllUsers();
}
