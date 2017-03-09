package ioc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:config/simpleContext.groovy")
class GroovyConfigTest {

//    @Autowired
//    private MessageGenerator groovyHelloMessageGenerator;

    @Autowired
    private String patronymic;

    @Autowired
    private String lastName;

    @Test
    void name() {
        assertNotNull(patronymic);
        assertNotNull(lastName);
    }
}
