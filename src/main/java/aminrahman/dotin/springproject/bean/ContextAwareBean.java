package aminrahman.dotin.springproject.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextAwareBean implements AwareBean {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        AnotherBean bean = this.applicationContext.getBean(AnotherBean.class);
        bean.printHello();
    }
}
