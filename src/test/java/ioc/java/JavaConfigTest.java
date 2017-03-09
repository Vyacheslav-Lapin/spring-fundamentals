package ioc.java;

import com.epam.trainings.spring.ioc.MessageGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaConfig.class)
class JavaConfigTest {

    @Autowired
    private MessageGenerator javaHelloMessageGenerator;

    @Test
    void testGetMessageOnJavaConfig() throws Exception {
        assertThat(javaHelloMessageGenerator.getMessage(),
                is("Hello, Фёдор Викторович Емельяненко!"));
    }
}
