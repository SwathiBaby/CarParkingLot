package com.swathiBaby.parkingLot.Util;

import com.swathiBaby.parkingLot.Model.ParkingDetails;
import com.swathiBaby.parkingLot.Service.ParkingDetailsService;

public class InputParserUtil {
	private static ParkingDetails[] lot=null;
	
	private static final String commandList[] = { "create_parking_lot", "park", "leave", "status",
			"registration_numbers_for_cars_with_colour", "slot_numbers_for_cars_with_colour",
			"slot_number_for_registration_number" };
	
	private static boolean iscommandExist(String  command) {
		
		for(int i=0; i<commandList.length;i++) {
			if(command==commandList[i]) {
				return true;
			}
		}
		
		return false;
		
	}

	public static void parseTextInput(String inputString) {

		String[] inputs = inputString.split(" ");
		if(inputs.length!=0 && !iscommandExist(inputs[0])){
			switch(inputs[0]){
				case "create_parking_lot" : createParkingLot(Integer.parseInt(inputs[1]));
					                           break;
				case "park":parkingVehicle(inputs[1],inputs[2]);
				              break;
					          
				case "leave":
					         
				case  "status":
					
				case  "registration_numbers_for_cars_with_colour":
					
				case  "slot_numbers_for_cars_with_colour":	
					
				case  "slot_number_for_registration_number":	
					                
					
				
			}
		
			
	
		}else{
		System.out.println("Common not found");
		}
	}
	
	private static void createParkingLot(int lotSize) {
		lot=new ParkingDetails[lotSize];
		System.out.println(String.format("Created a parking lot with %d slots", lot.length));
	}
	
	private static void parkingVehicle(String registration,String color) {
		int slot=-1;
		for(int i=0;i<lot.length;i++) {
			if(lot[i]==null) {
				slot=i;
				break;
			}
		}
		if(slot==-1) {
			System.out.println("Sorry, parking lot is full");
		}else {
			ParkingDetails parkingDetails=new ParkingDetails();
			parkingDetails.setRegistrationNo(registration);
			parkingDetails.setColor(color);
			parkingDetails.setSlotNumber(slot+1);
			lot[slot]=parkingDetails;
			System.out.println(String.format("Allocated slot number %d", parkingDetails.getSlotNumber()));
		}
		
	}
	
	
	private static void leaveParkingSlot(int lotsize) {
		
	}
}
