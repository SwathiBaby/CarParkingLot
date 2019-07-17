package com.swathiBaby.parkingLot.ServiceImple;

import com.swathiBaby.parkingLot.Service.ParkingDetailsService;

public class FileBasedInterpreter  implements ParkingDetailsService{

	@Override
	public void start() {
		System.out.println("Implementation type : "+FileBasedInterpreter.class.getName());
		
	}

	
	
	
}
