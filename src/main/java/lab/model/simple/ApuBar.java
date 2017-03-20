package lab.model.simple;

import lab.aop.AopLog;
import lab.model.Bar;
import lab.CustomerBrokenException;
import lab.model.Squishy;
import lab.model.User;

public class ApuBar implements Bar {

    @Override
	public Squishy sellSquishy(User customer)  {
        if (customer.isBroke())
            throw new CustomerBrokenException();
        AopLog.append("Here is your Squishee \n");
        return new SimpleSquishy("Usual Squishee");
    }
}
