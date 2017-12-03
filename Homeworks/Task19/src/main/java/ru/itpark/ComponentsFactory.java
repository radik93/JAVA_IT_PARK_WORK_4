package ru.itpark;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.lang.reflect.Constructor;

public class ComponentsFactory {
    private static  ComponentsFactory instance = new ComponentsFactory();
    // private constructor

    private Properties properties;

    private ComponentsFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

    }

    public static ComponentsFactory getInstance() {
        return instance;
    }

    public UsersDao getUsersDao()
    {


        try{
         String UsersDaoClassName = properties.getProperty("Jdbc.component.class");

         String DRIVER   = properties.getProperty("database.driver");
         String URL      = properties.getProperty("database.url");
         String USER     = properties.getProperty("database.username");
         String PASSWORD = properties.getProperty("database.password");

        Class<UsersDao> UsersDaoClass = (Class<UsersDao>)Class.forName(UsersDaoClassName);
        Constructor<UsersDao> UsersDaoConstructor = UsersDaoClass.getConstructor(String.class, String.class, String.class, String.class);
        UsersDao UsersDaoClassNameInstance = UsersDaoConstructor.newInstance(DRIVER, PASSWORD, URL, USER);
        return UsersDaoClassNameInstance;
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);}
    }
}
