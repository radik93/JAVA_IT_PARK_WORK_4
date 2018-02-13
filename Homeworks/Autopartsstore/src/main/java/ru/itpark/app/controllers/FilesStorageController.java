package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.app.forms.AddNewCar;
import ru.itpark.app.models.Car;
import ru.itpark.app.models.CarModel;
import ru.itpark.app.services.CarModelsService;
import ru.itpark.app.services.CarsService;
import ru.itpark.app.services.FilesStorageService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FilesStorageController {

  @Autowired
  private FilesStorageService storageService;

  @Autowired
  private CarsService carsService;

  @Autowired
  private CarModelsService carModelsService;

  @PostMapping(value = "/add/car")
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  public String handleCarAdd(AddNewCar addNewCar) {

    Car car;
    car = carsService.getCarByBrand(addNewCar.getBrand());
    if(car==null) {
      car = Car.builder()
              .brand(addNewCar.getBrand())
              .build();
      carsService.addCar(car);
    }
    CarModel carModel = CarModel.builder()
            .model(addNewCar.getModel())
            .car(car)
            .build();
    carModelsService.addCarModel(carModel);
    return storageService.saveImage(addNewCar.getFile(), carModel);
  }

  @PostMapping(value = "/files")
  @ResponseBody
  public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    return storageService.saveFile(file);
  }

  @GetMapping(value = "/files/{file-name:.+}")
  public void getFile(@PathVariable("file-name") String fileName,
                      HttpServletResponse response) {
    storageService.writeFileToResponse(fileName, response);
  }
}
