package ru.itpark.app.services;

import org.springframework.web.multipart.MultipartFile;
import ru.itpark.app.models.Car;
import ru.itpark.app.models.CarModel;

import javax.servlet.http.HttpServletResponse;

public interface FilesStorageService {
    String saveFile(MultipartFile file);
    void writeFileToResponse(String fileName, HttpServletResponse response);

    String saveImage(MultipartFile file, CarModel carModel);
}
