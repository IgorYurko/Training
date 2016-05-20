package iy.jspspring.training.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Theme2
{
    private final Theme theme;
    private final ThemeGenerator generator;

    public Theme2(Theme theme, ThemeGenerator generator)
    {
        this.theme = theme;
        this.generator = generator;
    }

    public Theme getTheme()
    {
        return theme;
    }

    public ThemeGenerator getGenerator()
    {
        return generator;
    }
}
