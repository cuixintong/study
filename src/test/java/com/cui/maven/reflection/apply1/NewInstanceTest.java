package com.cui.maven.reflection.apply1;

import org.junit.Test;

public class NewInstanceTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();


    }
}
