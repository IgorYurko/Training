package iy.jspspring.training.pojo;

import iy.jspspring.training.pojo.IUserPojo;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserPojo2
{
    @NotBlank
    private String name;

    private String[] password;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String[] getPassword()
    {
        return password;
    }

    public void setPassword(String[] password)
    {
        this.password = password;
    }
}
