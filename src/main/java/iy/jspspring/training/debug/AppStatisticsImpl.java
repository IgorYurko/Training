package iy.jspspring.training.debug;

import iy.jspspring.training.database.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class AppStatisticsImpl
{
    @Autowired
    private UserRepositoryImpl repository;
    private String s;

    public long getCount()
    {
        return repository.getCrudOperations().count();
    }
}
