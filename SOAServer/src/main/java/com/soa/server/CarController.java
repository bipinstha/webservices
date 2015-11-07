package com.soa.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soa.server.dto.Car;
import com.soa.server.dto.CarList;
import com.soa.server.service.CarService;

@RestController
@RequestMapping(value="/car")
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			headers = "accept=application/json, application/xml")
	public CarList getCars() {

		return carService.getAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			headers = "accept=application/json, application/xml")
	public Car addCar(@RequestBody Car car){
		this.carService.addCar(car);
		return car;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			headers = "accept=application/json, application/xml")
	public Car getOneCar(@PathVariable int id){
		return this.carService.getCarById(id);
	}

}
