package iy.jspspring.training.pojo;

import org.hibernate.validator.constraints.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Theme {

    @Pattern(regexp = "[a-zA-Z]+")
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String pass;

    public Theme(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
