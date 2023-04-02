package com.cui.maven.reflextion;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {//反射可以调用私有属性，和私有方法，通过设置setAccessible(true)获得权限

    @Test
    public void test() throws Exception {

        Class<Person> pc = Person.class;

        Constructor<Person> cons = pc.getDeclaredConstructor(String.class, int.class);

        Person p1 = cons.newInstance("tmo", 12);
        System.out.println(p1);

        Person p2 = cons.newInstance("jack", 22);

        Field name = pc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"kally");
        System.out.println(p2);

        Method toString = pc.getMethod("toString");
        String invoke = (String) toString.invoke(p1);
        System.out.println(invoke);

    }

    @Test
    public void test2() throws Exception {

        //首先使用反射把类加载，然后用类调用构造方法生成构造器，然后用类生成属性和方法的实例，然后对实例赋值使用set，调用方法使用invoke
        Class<Person> clazz = Person.class;

        Constructor<Person> consNull = clazz.getDeclaredConstructor();
        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");

        Method toString = clazz.getMethod("toString");
        Person person = consNull.newInstance();

        person.setName("tom");
        person.setAge(12);
        String invoke = (String) toString.invoke(person);
        System.out.println(invoke);
    }
}
