package iy.jspspring.training.pojo;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:config/project.properties")
@ComponentScan("iy.jspspring.training.pojo")
public class AppConfig
{
//    @Bean
//    @Scope("prototype")
//    public Theme theme()
//    {
//        return new Theme("Vasia", "");
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Theme theme1()
//    {
//        return new Theme("Vasia", "");
//    }
//
//    @Bean
//    public ThemeGenerator generator()
//    {
//
//        return new ThemeGenerator()
//        {
//            @Override
//            public Theme getWorker()
//            {
//                return theme();
//            }
//        };
//    }
//
//    @Bean
//    public Theme2 theme2()
//    {
//        return new Theme2(theme(), generator());
//    }
}
