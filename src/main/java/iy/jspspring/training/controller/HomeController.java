package iy.jspspring.training.controller;

import iy.jspspring.training.database.entity.Role;
import iy.jspspring.training.database.entity.User;
import iy.jspspring.training.database.service.ProjectRepositoryServiceJpa;
import iy.jspspring.training.pojo.Theme;
import iy.jspspring.training.pojo.UserPojo;
import iy.jspspring.training.pojo.UserPojo2;
import iy.jspspring.training.some.ClassWithBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
//@SessionAttributes("theme")
public class HomeController {
//    @ModelAttribute("theme")
//    public Theme getTheme(HttpServletRequest request, HttpServletResponse response){
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null){
//            for (Cookie cookie : cookies)
//            {
//                if (cookie.getName().equals("themeCookie")){
//                    return new Theme(cookie.getValue());
//                }
//            }
//        }
//        response.addCookie(new Cookie("themeCookie", "default"));
//        return new Theme("default");
//    }

    private final ProjectRepositoryServiceJpa<User> userService;
    private final ProjectRepositoryServiceJpa<Role> roleService;
//    private final LocalValidatorFactoryBean validator;

    @Autowired
    public HomeController(@Qualifier("userRepoSrv") ProjectRepositoryServiceJpa<User> userService,
                          @Qualifier("roleRepoSrv") ProjectRepositoryServiceJpa<Role> roleService
//                          @Qualifier("validator") LocalValidatorFactoryBean validator)
    ) {
        this.userService = userService;
        this.roleService = roleService;
//        this.validator = validator;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String indexGet(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<User> all = userService.findAll();
        List<User> all1 = userService.findAll1();
        List<User> all2 = userService.findAll2();
        model.addAttribute("all", all);
        roleService.findAll();
        roleService.findAll1();
        roleService.findAll2();
        Theme theme = new Theme("", "");
//        Set<ConstraintViolation<Theme>> validate = validator.validateProperty(theme, "name");

        return "index";
    }

//    @Autowired
//    private UserServiceImpl userService;

//    @Autowired
//    private UserPojo userDao;

//    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
//    public String indexGet(Model model, HttpServletRequest request)
//    {
////        List result = sessionFactory.getCurrentSession()
////                .createCriteria(User.class, "u")
////                .add(Restrictions.eq("u.id", 1))
////                .setFetchMode("u.roles", FetchMode.JOIN)
//////                .createQuery("from User u where u.id=1")
////                .list();
////        if (principal instanceof UsernamePasswordAuthenticationToken)
////            model.addAttribute("test", principal.getName());
////        else
////        model.addAttribute("test", userService.getUserById(1));
////        model.addAttribute("test2", userService.getAllUsers());
////        String[] line = {"roles"};
////        model.addAttribute("test3", userDao.findById(1, line));
//////        response.addCookie(new Cookie("coo", "Hello I Cookie"));
//////        session.setAttribute("userSession", new UserPojo("Vasia", "1234"));
//////        model.addAttribute("str", str);
//////        model.addAttribute("request", request);
////        Integer integer = 10;
//        model.addAttribute()
//        return "index";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ROLE_USER')")
//    public String index(Model model)
//    {
//        List result = sessionFactory.getCurrentSession()
//                .createCriteria(Category.class)
//                .add(Restrictions.eq("id", new Integer(3)))
//                .list();
//
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        boolean authenticated = securityContext.getAuthentication().isAuthenticated();
//        UserPojo principal = (UserPojo) securityContext.getAuthentication().getPrincipal();
//        boolean role_user = principal.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
////        response.addCookie(new Cookie("coo", "Hello I Cookie"));
////        session.setAttribute("userSession", new UserPojo("Vasia", "1234"));
//
//        model.addAttribute("test", principal.getUsername());
////        model.addAttribute("str", str);
////        model.addAttribute("request", request);
//
//        return "jspindex";
//    }


    @RequestMapping(value = "/some", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    @ResponseBody
    public UserPojo2 indexRest(/*@Valid */@RequestBody UserPojo user,
                               @CookieValue(value = "query", defaultValue = "dfdf", required = false)
                               String query) {
        UserPojo2 user2 = new UserPojo2();
        user2.setName(user.getName());
        user2.setPassword(new String[]{"Shud", "work"});
//        List<UserPojo> objects = new ArrayList<>();
//        objects.add(new UserPojo("igor", "wert"));
//        objects.add(new UserPojo("vasia", "sdfgg"));
//        user2.setPassword(objects);
        ClassWithBuilder.Builder builder = ClassWithBuilder.Builder.newBuilder();
        ClassWithBuilder build = builder.setName("Vasia").setAge("123").build();
        String ages = build.getAge();

        return user2;
    }

    @RequestMapping(value = "/home/{page}", method = RequestMethod.GET)
    public String homeGet(@PathVariable("page") Integer page, Model model, HttpServletRequest request) {
        model.addAttribute("page", page);
        model.addAttribute("request", request);
        Enumeration<String> parameterNames = request.getAttributeNames();
        Map<String, Object> parametersMap = new TreeMap<>();
        while (parameterNames.hasMoreElements()) {
            String nextElement = parameterNames.nextElement();
            parametersMap.put(nextElement, request.getAttribute(nextElement));
        }

        return "index";
    }
}
