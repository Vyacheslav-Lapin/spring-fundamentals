import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyTest {

    @FunctionalInterface
    interface Messanger {
        String getMessage();
    }

    Messanger messanger = () -> "Hello, World!";

    @Test
    void name() {
        Messanger proxyMessanger = (Messanger) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class<?>[]{Messanger.class},
                (proxy, method, args) -> {
                    if (method.getDeclaringClass() == Object.class)
                        switch (method.getName()) {
                            case "equals":
                                return args[0] != null && args[0].equals(messanger);
                            case "hashCode":
                                return System.identityHashCode(messanger);
                            case "toString":
                                return proxy.getClass().getName() + "@" +
                                        Integer.toHexString(System.identityHashCode(proxy)) +
                                        ", with InvocationHandler";
                            default:
                                throw new IllegalStateException(String.valueOf(method));
                        }
                    return messanger.getMessage() + " from Proxy!";
                }
        );

        assertThat(proxyMessanger.getMessage(), is(String.format("%s from Proxy!", messanger.getMessage())));
        assertEquals(proxyMessanger, messanger);
    }
}
