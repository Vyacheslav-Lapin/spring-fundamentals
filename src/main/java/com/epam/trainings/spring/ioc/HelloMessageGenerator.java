package com.epam.trainings.spring.ioc;

public interface HelloMessageGenerator extends MessageGenerator {
    @Override
    default String getMessage(){ return "Hello, " + toString() + "!"; }
}
