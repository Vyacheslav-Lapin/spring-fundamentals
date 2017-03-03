import lab.CustomerBrokenException;
import lab.aop.AopLog;
import lab.model.Bar;
import lab.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class AopAspectJExceptionTest {

	@Autowired
	private Bar bar;
    
	@Autowired
    private Customer customer;


    public void setUp() throws Exception {
//        customer.setBroke(true);
    }

    @Test
    public void testAfterThrowingAdvice() {
 
    	assertThrows(CustomerBrokenException.class, () -> bar.sellSquishee(customer));
    	
        assertTrue("Customer is not broken ", AopLog.getStringValue().contains("Hmmm..."));
        System.out.println(AopLog.getStringValue());
    }
}