package ru.itpark.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import ru.itpark.app.models.CarModel;
import ru.itpark.app.models.User;

@Data
@Builder
@AllArgsConstructor
public class CarModelsDto {


  private String model;
  private String imageUrl;

  public static CarModelsDto from(CarModel model) {
    CarModelsDto result = CarModelsDto.builder()
        .model(model.getModel())
        .build();


    if (model.getImage() != null) {
      result.imageUrl = "file://localhost/c$/Storage/" + model.getImage().getStorageFileName();
      System.out.println(result.imageUrl);
    }

    return result;
  }
}
