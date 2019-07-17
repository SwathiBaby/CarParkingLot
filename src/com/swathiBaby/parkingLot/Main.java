package com.swathiBaby.parkingLot;

import java.io.BufferedReader;
import java.io.InputStreamReader;


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
	    		 parkingService= new FileBasedInterpreter();
	    	 }
	    	 parkingService.start();
	}
}
		
		



