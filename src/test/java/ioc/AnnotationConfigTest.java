package ioc;

import com.epam.trainings.spring.ioc.MessageGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class AnnotationConfigTest {

    @Autowired
    private MessageGenerator annotationHelloMessageGenerator;

    @Test
    void correctlyInsertedByAnnotation() {
        assertNotNull(annotationHelloMessageGenerator);
    }

    @Test
    void testGetMessageOnAnnotations() throws Exception {
        assertEquals("Hello, Василий Иванович Емельяненко!",
                annotationHelloMessageGenerator.getMessage());
    }
}
