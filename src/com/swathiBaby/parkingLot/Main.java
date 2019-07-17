package com.swathiBaby.parkingLot;

import com.swathiBaby.parkingLot.Service.ParkingDetailsService;
import com.swathiBaby.parkingLot.ServiceImple.CommandPromptBasedInterpretor;
import com.swathiBaby.parkingLot.ServiceImple.FileBasedInterpreter;

public class Main
{
	 static ParkingDetailsService parkingService;

	    public static void main(String[] args) {
	    	 if(args.length==0) {
	    		parkingService=new CommandPromptBasedInterpretor();
	    	 }else if(args.length==1) {
	    		 try {
	    		 parkingService= new FileBasedInterpreter(args[0]);
	    		 }catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}
	    	 } 
	    	 parkingService.start();
	}
}
		
		



