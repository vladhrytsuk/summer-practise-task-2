package com.car.service.impl;

import com.car.dto.CarDTO;
import com.car.dto.CarFactoryDTO;
import com.car.entity.Car;
import com.car.repository.CarRepository;
import com.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService
{
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarFactoryDTO carFactoryDTO;

    @Transactional
    @Override
    public Car saveCar(CarDTO carDTO)
    {
        Car car = carFactoryDTO.SerializerCar(carDTO);
        car = carRepository.save(car);
        return car;
    }

    @Transactional
    @Override
    public Car deleteCar(String id)
    {
        Car deletedCar = findById(id);
        carRepository.delete(deletedCar);
        return deletedCar;
    }

    @Transactional
    @Override
    public Car updateCar(Car car)
    {
        Car updatedCar = findById(car.getId());
        updatedCar.setMark(car.getMark());
        updatedCar.setColor(car.getColor());
        updatedCar.setVin(car.getVin());
        updatedCar.setMiles(car.getMiles());
        return updatedCar;
    }

    @Transactional(readOnly = true)
    @Override
    public Car findById(String id)
    {
        return carRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findAll()
    {
        return (List<Car>) carRepository.findAll();
    }
}
