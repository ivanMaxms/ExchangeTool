package com.exchangeproject.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exchangeproject.controllers.Position;

@FeignClient(name="exchangeproject-position-tracker")
public interface RemotePositionMicroserviceCalls 
{
	// REST Call
	// /vehicles/{name}
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/{name}")
	Position getLatestPositionForVehicle(@PathVariable("name") String name);
}
