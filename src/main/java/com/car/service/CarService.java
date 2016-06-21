package com.car.service;

import com.car.dto.CarDTO;
import com.car.entity.Car;

import java.util.List;

public interface CarService
{
    Car saveCar(CarDTO carDTO);
    Car deleteCar(String id);
    Car updateCar(Car car);
    Car findById(String id);
    List<Car> findAll();
}
