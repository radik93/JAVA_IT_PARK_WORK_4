package ru.itpark.servlets;

import ru.itpark.models.Autopart;
import ru.itpark.models.Car;
import ru.itpark.repository.AutopartsRepository;
import ru.itpark.repository.AutopartsRepositoryEntityManagerImpl;
import ru.itpark.repository.CarsRepository;
import ru.itpark.repository.CarsRepositoryEntityManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarsJspServlet extends HttpServlet {

    private CarsRepository carsRepository;

    private AutopartsRepository autopartsRepository;

    @Override
    public void init() throws ServletException {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("ru.itpark.persistence")
                        .createEntityManager();
        carsRepository = new CarsRepositoryEntityManagerImpl(entityManager);

        autopartsRepository = new AutopartsRepositoryEntityManagerImpl(entityManager);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carsRepository.findAll();

        req.setAttribute("cars", cars);

        req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        int count = Integer.parseInt(req.getParameter("count"));

        if(carsRepository.findName(brand, model) == null) {
            Car car = Car.builder()
                    .brand(brand)
                    .model(model)
                    .build();
            carsRepository.save(car);
        }
        Autopart autopart = Autopart.builder()
                .name(name)
                .type(type)
                .count(count)
                .reserve(0)
                .car_id(1L)
                .build();
        autopartsRepository.save(autopart);

        resp.sendRedirect("/cars_as_jsp");
    }
}
