package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itpark.app.dto.CarModelsDto;
import ru.itpark.app.models.Car;
import ru.itpark.app.models.CarModel;
import ru.itpark.app.services.CarModelsService;
import ru.itpark.app.services.CarsService;

import java.util.List;

@Controller
public class MainControllers {

    List<Car> carList;

    List<CarModelsDto> carModelsDtoList;

    @Autowired
    private CarsService carsService;

    @Autowired
    private CarModelsService carModelsService;

    @GetMapping("/index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }

    @GetMapping("/cars")
    public String getCarsPage(@ModelAttribute("model") ModelMap model) {
        carList = carsService.getAllCars();
        model.addAttribute("carList", carList);
        return "cars";
    }

    @GetMapping("/addnewcar")
    public String getAddNewCarPage() {
        return "addnewcar";
    }

    //@RequestMapping(value = "/cars/model", method = RequestMethod.GET)
    @GetMapping("/carsmodel")
    public String getCarModelsPage(@RequestParam("id") Long id, @ModelAttribute("model") ModelMap model) {

        if (carModelsDtoList!=null)
        {
            carModelsDtoList.clear();
        }
        carModelsDtoList = carModelsService.getAllCarsModelById(id);
        System.out.println(carModelsDtoList);
        model.addAttribute("carModelsDtoList", carModelsDtoList);

        return "carmodels";
    }

}
