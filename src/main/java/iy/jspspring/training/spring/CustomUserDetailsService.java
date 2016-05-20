package iy.jspspring.training.spring;

import iy.jspspring.training.database.entity.User;
import org.apache.commons.lang.WordUtils;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class CustomUserDetailsService implements UserDetailsService
{
//    @Autowired
    private SessionFactory sessionFactory;

    public CustomUserDetailsService()
    {
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        s = WordUtils.capitalize(s.toLowerCase());

        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class, "u")
                .add(Restrictions.eq("u.firstName", s))
                .setFetchMode("u.roles", FetchMode.JOIN)
                .setMaxResults(1)
                .uniqueResult();
        if (user == null) throw new UsernameNotFoundException("User" + s + "not found");

        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(e -> new SimpleGrantedAuthority(e.getName()))
                .collect(Collectors.toList());

        return new CustomUserDetails(user.getFirstName(), user.getPassword(), authorities);
    }
}
