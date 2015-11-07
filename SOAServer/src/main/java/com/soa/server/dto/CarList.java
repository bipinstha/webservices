package com.soa.server.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cars")
public class CarList {

	private List<Car> cars;

	public CarList() {
	}

	public CarList(List<Car> cars) {
		this.cars = cars;
	}

	@XmlElement(name = "car")
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
