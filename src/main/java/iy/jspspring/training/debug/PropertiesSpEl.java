package iy.jspspring.training.debug;

import org.springframework.stereotype.Component;

@Component("projectProp")
public class PropertiesSpEl
{
    public final String name = "Igor";

    private PropertiesSpEl() {
    }
}
