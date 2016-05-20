package iy.jspspring.training.database.service;

import java.io.Serializable;
import java.util.List;

public interface ProjectRepositoryServiceJpa<T extends Serializable>
{
    List<T> findAll();
    List<T> findAll1();
    List<T> findAll2();
}
