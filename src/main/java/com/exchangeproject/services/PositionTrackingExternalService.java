package com.exchangeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.exchangeproject.controllers.Position;
import com.exchangeproject.data.VehicleRepository;
import com.exchangeproject.domain.Vehicle;

@Service 
public class PositionTrackingExternalService 
{
	@Autowired
	private RemotePositionMicroserviceCalls remoteService;
	
	@Autowired 
	private VehicleRepository repository;
	
	@HystrixCommand(fallbackMethod="handleExternalServiceDown")
	public Position getLatestPositionForVehicleFromRemoteMicroservice(String name)
	{
		Position response = remoteService.getLatestPositionForVehicle(name);
		response.setVehicleName(name);
		response.setUpToDate(true);
		return response;
	}
	
	
	public Position handleExternalServiceDown(String name)
	{
		// Read the last known position for this vehicle
		Position position = new Position();
		Vehicle vehicle = repository.findByName(name);
		position.setLat(vehicle.getLat());
		position.setLongitude(vehicle.getLongitude());
		position.setTimestamp(vehicle.getLastRecordedPosition());
		position.setUpToDate(false);
		return position;
	}
	
}
