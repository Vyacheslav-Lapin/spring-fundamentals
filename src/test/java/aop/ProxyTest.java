package aop;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyTest {

    @FunctionalInterface
    interface Messenger {
        String getMessage();
    }

    private Messenger messenger = () -> "Hello, World!";

    @Test
    void name() {
        Messenger proxyMessenger = (Messenger) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class<?>[]{Messenger.class},
                (proxy, method, args) -> {
                    if (method.getDeclaringClass() == Object.class)
                        switch (method.getName()) {
                            case "equals":
                                return args[0] != null && args[0].equals(messenger);
                            case "hashCode":
                                return System.identityHashCode(messenger);
                            case "toString":
                                return proxy.getClass().getName() + "@" +
                                        Integer.toHexString(System.identityHashCode(proxy)) +
                                        ", with InvocationHandler";
                            default:
                                throw new IllegalStateException(String.valueOf(method));
                        }
                    return messenger.getMessage() + " from Proxy!";
                }
        );

        assertThat(proxyMessenger.getMessage(), is(String.format("%s from Proxy!", messenger.getMessage())));
        assertEquals(proxyMessenger, messenger);
    }
}
