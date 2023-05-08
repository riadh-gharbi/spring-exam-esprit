package tn.examb.riadhgharbi.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//Component is the biggest stereotype (it has the broadest semantics) and serves as a generic stereotype for any Spring-managed component.
@Component
@Slf4j
public class LoggingAspect {
    @After("execution(* tn.examb.riadhgharbi.services.*.add*(..))")
    public void outMethod(JoinPoint joinPoint)
    {
        log.info("méthode exécutée");
    }
}
