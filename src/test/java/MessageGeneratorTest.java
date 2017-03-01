import com.epam.trainings.spring.ioc.MessageGenerator;import org.junit.jupiter.api.Test;import org.junit.jupiter.api.extension.ExtendWith;import org.springframework.beans.BeansException;import org.springframework.beans.factory.BeanFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.ApplicationContext;import org.springframework.context.ApplicationContextAware;import org.springframework.test.context.ContextConfiguration;import org.springframework.test.context.junit.jupiter.SpringExtension;import java.util.function.BooleanSupplier;import static java.lang.System.currentTimeMillis;import static java.lang.System.out;import static java.lang.Thread.sleep;import static org.junit.jupiter.api.Assertions.assertEquals;/** * @author Vyacheslav * @version 0.1 (02.04.2015). */@ExtendWith(SpringExtension.class)//@ContextConfiguration("/AppConfig.groovy")@ContextConfiguration(classes = com.epam.trainings.spring.ioc.java.AppConfig.class)//@ContextConfiguration("classpath:spring-config.xml") В AppConfig уже включён (@ImportResource) spring-config.xmlpublic class MessageGeneratorTest implements ApplicationContextAware {    @Autowired    private MessageGenerator xmlHelloMessageGenerator;    @Test    void testGetMessageOnXML() throws Exception {        assertEquals("Hello, Фёдор Владимирович Емельяненко!", xmlHelloMessageGenerator.getMessage());    }    @Autowired    private MessageGenerator annotationHelloMessageGenerator;    @Test    void testGetMessageOnAnnotations() throws Exception {        assertEquals("Hello, Василий Иванович Емельяненко!", annotationHelloMessageGenerator.getMessage());    }    @Autowired    private MessageGenerator javaHelloMessageGenerator;    @Test    void testGetMessageOnJavaConfig() throws Exception {        assertEquals("Hello, Фёдор Владимирович Емельяненко!", javaHelloMessageGenerator.getMessage());    }    private BeanFactory beanFactory;    @Override    public void setApplicationContext(ApplicationContext context) throws BeansException {        beanFactory = context;    }    @Test    void testGetMessageOnXmlConfigWithGroovyBean() throws Exception {        testProcess(() -> p(beanFactory.getBean("groovyHelloMessageGenerator", MessageGenerator.class).getMessage())                .equals("Hello, Фёдор Владимирович Емельяненко!"), 1000);    }    private static void testProcess(BooleanSupplier supplier, int delay) throws InterruptedException {        while (!supplier.getAsBoolean())            sleep(delay);    }    private static String p(String s) {        out.println(currentTimeMillis() + ": " + s);        return s;    }}