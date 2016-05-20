package iy.jspspring.training.debug;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UsePropertiesSpEl
{
    @Value("${servlet.jspViewResolver.prefix}")
    public String name;
}
