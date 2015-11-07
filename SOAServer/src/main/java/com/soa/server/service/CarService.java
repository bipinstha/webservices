package com.soa.server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.soa.server.dto.Car;
import com.soa.server.dto.CarList;

@Service
public class CarService {

	Map<Integer, Car> cars = new HashMap<>();

	public CarService() {
		cars.put(1, new Car(1, "N1100", "Hundai", "I10"));
		cars.put(2, new Car(2, "N1122", "Hundai", "I20"));
		cars.put(3, new Car(3, "N1133", "Hundai", "I30"));
	}

	public void addCar(Car car) {
		cars.put(car.getId(), car);
	}

	public Car getCarById(int id) {
		return cars.get(id);
	}

	public CarList getAll() {
		return new CarList(new ArrayList<>(cars.values()));
	}

}
