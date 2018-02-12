package ru.itpark.app.forms;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddNewCar {
    private String brand;
    private String model;
    MultipartFile file;
}
