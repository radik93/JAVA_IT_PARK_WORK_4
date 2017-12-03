package ru.itpark;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ComponentsFactory componentsFactory = ComponentsFactory.getInstance();

        UsersDao usersDao = componentsFactory.getUsersDao();

        HumanService service = new HumanService(usersDao);

        List<User> users = usersDao.findAll();

        System.out.println(users);
    }
}
