package iy.jspspring.training.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProjectBeanPostProcessor implements BeanPostProcessor
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        StringBuilder str = new StringBuilder();
        String name = beanName.substring(0, 1).toUpperCase() + beanName.substring(1);
        str.append("--- ").append(name).append(" bean is initialize.").append(" ---");
                LOGGER.info(str.toString());

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        LOGGER.info(bean.toString());

        return bean;
    }
}
