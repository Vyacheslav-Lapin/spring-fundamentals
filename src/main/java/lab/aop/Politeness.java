package lab.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import lab.model.Customer;
import lab.model.Squishy;

@Aspect
public class Politeness {

    @Before("execution(* sellSquishee(lab.model.Customer, ..))")
    public void sayHello(JoinPoint joinPoint) {
        String customerName = ((Customer) joinPoint.getArgs()[0]).getName();
        AopLog.printf("Hello %s. How are you doing?%n", customerName);
    }

    @AfterReturning(pointcut = "execution(* sellSquishee(..))",
            returning = "retVal", argNames = "retVal")
    public void askOpinion(Object retVal) {
        String name = ((Squishy) retVal).getName();
        AopLog.printf("Is %s Good Enough?%n", name);
    }

    @AfterThrowing("execution(* sellSquishee(..))")
    public void sayYouAreNotAllowed() {
        AopLog.append("Hmmm...\n");
    }

    @After("execution(* sellSquishee(..))")
    public void sayGoodBye() {
        AopLog.append("Good Bye!\n");
    }

    @Around("execution(* sellSquishee(..))")
    public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) throws Throwable {
        AopLog.append("Hi!\n");
        Object retVal = pjp.proceed();
        AopLog.append("See you!\n");
        return retVal;
    }
}