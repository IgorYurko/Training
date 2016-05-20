package iy.jspspring.training.dao.intrf;

import java.io.Serializable;
import java.util.List;

public interface OperationsDao<T extends Serializable>
{
   List<T> findAll();
   T findById(Integer id);
   T findById(Integer id, String[] fetchModelEagerLine);
}
