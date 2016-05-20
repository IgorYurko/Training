package iy.jspspring.training.util.validator.impl;

import iy.jspspring.training.util.validator.kernel.AbstractProjectValidatorErrors;
import iy.jspspring.training.util.validator.kernel.ProjectBeansGenerator;
import iy.jspspring.training.util.validator.kernel.ProjectValidatorUtil;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/* If you wont to use all static method from ProjectValidatorUtil add in applicationContext.xml this bean:
*       <bean id="defaultValidatorUtil" class="you.package.validator.impl.DefaultValidatorUtil">
*            <constructor-arg name="validator">
*                <bean class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean"/>
*            </constructor-arg>
*       </bean>
* At now you must to use DefaultValidatorUtil class as DefaultValidatorUtil.isValid(youObject).
*
* */
public final class DefaultValidatorUtil extends ProjectValidatorUtil {
    public DefaultValidatorUtil(LocalValidatorFactoryBean validator) {
        super();
        super.setValidator(validator);
        ProjectBeansGenerator<AbstractProjectValidatorErrors> generator = () -> new AbstractProjectValidatorErrors() {};
        super.setGenerator(generator);
    }
}