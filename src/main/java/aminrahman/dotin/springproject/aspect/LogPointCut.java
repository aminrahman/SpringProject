package aminrahman.dotin.springproject.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class LogPointCut {

    @Pointcut("@annotation(ExecuteTime)")
    public void logExecutionTimePointcut(){}
}
