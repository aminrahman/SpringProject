package aminrahman.dotin.springproject.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonBean implements ContextRequired {

    private final Logger logger = LoggerFactory.getLogger(SingletonBean.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        logger.info("setApplicationContext from " + this.getClass().getName() + " and applicationContext is " + this.applicationContext.getDisplayName());
    }
}
