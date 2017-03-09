package lab.model;

import lab.aop.AopLog;

public class ApuBar implements Bar {

	public Squishy sellSquishee(Customer customer)  {
        if (customer.isBroke()){
            throw new CustomerBrokenException();
        }
        AopLog.append("Here is your Squishy \n");
        return new Squishy("Usual Squishy");
    }
}