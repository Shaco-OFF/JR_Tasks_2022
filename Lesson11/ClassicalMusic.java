package Lesson11;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

;

/**
 * @author Neil Alishev
 */
@Component
public class ClassicalMusic implements Music {
    @PostConstruct
    public void doMyInit() {
        System.out.println("init-method");
    }
    @PreDestroy
    public void doMyDestruct() {
        System.out.println("destroy-method");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
