package lab.model;

public interface User extends Person {

    int getId();

    String getFirstName();

    String getLastName();

    boolean isBroke();
    void setBroke(boolean broke);
}
