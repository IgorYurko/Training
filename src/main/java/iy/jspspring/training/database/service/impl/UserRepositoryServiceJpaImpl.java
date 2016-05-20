package iy.jspspring.training.database.service.impl;

import iy.jspspring.training.database.entity.User;
import iy.jspspring.training.database.jpa.kernel.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userRepoSrv")
public class UserRepositoryServiceJpaImpl extends AbstractProjectRepositoryServiceJpa<User, Integer> {

    @Autowired
    public UserRepositoryServiceJpaImpl(@Qualifier("userRepo") ProjectRepository<User, Integer> repository) {
        super(repository, User.class);
    }
}
