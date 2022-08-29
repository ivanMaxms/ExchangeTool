package com.exchangeproject.data;

import com.exchangeproject.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>
{
	public Vehicle findByName(String name);
} 
