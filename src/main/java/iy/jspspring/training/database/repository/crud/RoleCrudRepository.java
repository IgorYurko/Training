package iy.jspspring.training.database.repository.crud;

import iy.jspspring.training.database.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleCrudRepository extends CrudRepository<Role, Integer> {
}
