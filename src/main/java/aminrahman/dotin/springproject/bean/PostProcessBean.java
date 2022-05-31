package aminrahman.dotin.springproject.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Component
public class PostProcessBean implements ApplicationContextAware, BeanPostProcessor {

    private final Logger logger = LoggerFactory.getLogger(PostProcessBean.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Scope annotation = AnnotationUtils.getAnnotation(bean.getClass(), Scope.class);
        if (annotation != null) {
            if (annotation.value().equals(ConfigurableBeanFactory.SCOPE_SINGLETON)) {
                logger.info("Logging name of singleton beans: " + beanName);
            }
        }

        if (bean instanceof ContextRequired) {
            ((ContextRequired) bean).setApplicationContext(this.applicationContext);
        }
        return bean;
    }
}
