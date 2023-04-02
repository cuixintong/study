package com.cui.maven.reflection.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class JuicerTest {

    @Test
    public void test() throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Properties properties = new Properties();
        File file = new File("src/config.properties");
        System.out.println(file.getAbsolutePath());
        properties.load(new FileReader(file));

        String fruitName = properties.getProperty("fruitName");
        System.out.println(fruitName);

        Class<?> aClass = Class.forName(fruitName);
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Fruit f = (Fruit) declaredConstructor.newInstance();

        Class<Juicer> juicerClass = Juicer.class;
        Constructor<Juicer> declaredConstructor1 = juicerClass.getDeclaredConstructor();
        Juicer juicer = declaredConstructor1.newInstance();

        Method run = juicerClass.getMethod("run", Fruit.class);
        run.invoke(juicer,f);

    }
}
