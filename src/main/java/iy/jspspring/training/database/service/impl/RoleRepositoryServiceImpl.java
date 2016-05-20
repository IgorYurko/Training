package iy.jspspring.training.database.service.impl;

import iy.jspspring.training.database.entity.Role;
import iy.jspspring.training.database.jpa.kernel.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("roleRepoSrv")
public class RoleRepositoryServiceImpl extends AbstractProjectRepositoryServiceJpa<Role, Integer> {

    @Autowired
    public RoleRepositoryServiceImpl(@Qualifier("roleRepo") ProjectRepository<Role, Integer> repository) {
        super(repository, Role.class);
    }
}
