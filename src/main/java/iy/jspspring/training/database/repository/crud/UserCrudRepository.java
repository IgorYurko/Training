package iy.jspspring.training.database.repository.crud;

import iy.jspspring.training.database.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
}