package iy.jspspring.training.pojo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ThemeTest
{

    @Autowired
    @Qualifier("theme1")
    Theme theme;

    @Autowired
    ThemeGenerator generator;

    @Autowired
    Theme2 theme2;

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void controllerInjectionTest()
    {
        assertEquals("Vasia", theme.getName());
    }

    @Test
    public void whenLookupMethodThenReturnThemScopePrototype()
    {
        Theme theme1 = generator.getWorker();
        Theme theme2 = generator.getWorker();

        assertFalse(theme1 == theme2);
    }

    @Test
    public void controllerInjectionTest2()
    {
        assertEquals("Vasia", theme2.getTheme().getName());
        assertTrue(theme2.getGenerator().getWorker() != null);
    }
}