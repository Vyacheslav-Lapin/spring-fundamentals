package lab.model;

import org.springframework.stereotype.Component;

@Component
public interface Bar {
    Squishee sellSquishee(Customer customer);
}