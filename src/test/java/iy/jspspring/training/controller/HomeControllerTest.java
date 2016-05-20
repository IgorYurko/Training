package iy.jspspring.training.controller;

import iy.jspspring.training.database.jpa.kernel.ProjectRepository;
import iy.jspspring.training.util.validator.kernel.AbstractProjectValidatorErrors;
import iy.jspspring.training.util.validator.kernel.ProjectValidatorUtil;
import iy.jspspring.training.debug.UsePropertiesSpEl;
import iy.jspspring.training.database.entity.Role;
import iy.jspspring.training.database.entity.User;
import iy.jspspring.training.pojo.Theme;
import iy.jspspring.training.util.validator.impl.DefaultValidatorUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({@ContextConfiguration(locations = "classpath:test/testContext.xml")})
@ActiveProfiles("test")
public class HomeControllerTest/* extends AbstractTransactionalJUnit4SpringContextTests*/ {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeControllerTest.class);

    @Autowired
    WebApplicationContext context;

    @Autowired
    private ProjectRepository<User, Integer> userService;

    @Autowired
    private ProjectRepository<Role, Integer> roleService;

    //    @Autowired
    //    private ProjectValidatorUtil util;

    //    @Autowired
    //    private LocalValidatorFactoryBean validator;

    @Autowired
    private UsePropertiesSpEl el;

    MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        String name = el.name;
        System.out.println(name);
    }

    @Test
    public void testIndexGet() throws Exception {
        LOGGER.error("Test");
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("all"))
                .andExpect(model().attribute("all", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("firstName", is("Igor")),
                                hasProperty("email", is("igor.yurko.mail@gmail.com")
                                )
                ))))
                .andExpect(model().attribute("all", hasItem(allOf(hasProperty("id", is(2)), hasProperty("firstName", is("Vasia")), hasProperty("email", is("vasia.pupkin.mail@gmail.com"))))));
    }

    @Test
    public void databaseTest() {
        //        User user = new User();
        //        user.setId(1);
        //        user.setFirstName("Igor");
        //        user.setLastName("Test");
        //        user.setEmail("test.ua");
        //        user.setPassword("1234");
        //        user.setDateAuthorization(new Date(System.currentTimeMillis()));
        ////        HashSet<Role> roles = new HashSet<>();
        ////        Role role = new Role();
        ////        role.setName("ROLE_TEST");
        ////        role.setId(34);
        ////        Iterable<User> all = userService.getCrudOperations().findAll();
        ////        ArrayList<User> users = Lists.newArrayList(all);
        ////        User user1 = users.get(0);
        ////        user1.setFirstName("Test2222");
        ////        User user2 = users.get(1);
        ////        user2.setFirstName("Test2");
        ////        roles.add(role);
        ////        roleService.getCrudOperations().save(role);
        //        userService.getCrudOperations().save(user);
        ////        user.setRoles(roles);
        ////        userService.getEntityManager().flush();
        ////        System.out.println("");
    }

    @Test
    public void whenCreateObjectThemeThenCheckForValid() {
        Theme theme = new Theme(null, null);
        assertFalse(DefaultValidatorUtil.isValid(theme));
        StringBuilder info = new StringBuilder();
        Map<String, AbstractProjectValidatorErrors> fieldsAndErrors = DefaultValidatorUtil.getNotValidFieldsAndErrors(theme);
//        fieldsAndErrors.values().retainAll(Collections.singleton(null));
        fieldsAndErrors
                .forEach((k, v) ->{
                            info.append(k)
                            .append(" : ")
                            .append(v.getInvalidValue())
                            .append(" ")
                            .append(v.getMessage())
                            .append("\n");
                });
        LOGGER.info(info.toString());
        assertFalse(DefaultValidatorUtil.isValid(theme, "name", "pass"));
        //        assertTrue(validator.validateProperty(theme, "name").size() == 0);
        assertEquals("pass", ProjectValidatorUtil.getNotValidFields(theme)
                .get(0));
        assertTrue(DefaultValidatorUtil.isValid(theme, "name"));
        assertEquals(false, ProjectValidatorUtil.builder()
                .object(theme)
                .isValid());
        assertFalse(DefaultValidatorUtil.builder()
                .object(theme)
                .field("name")
                .field("pass")
                .isValid());
    }
}