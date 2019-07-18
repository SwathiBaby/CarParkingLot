package com.swathiBaby.parkingLot.Util;

import com.swathiBaby.parkingLot.Model.ParkingDetails;
import com.swathiBaby.parkingLot.Service.ParkingDetailsService;

public class InputParserUtil {
	private ParkingDetails[] lot = null;

	private final String commandList[] = { "create_parking_lot", "park", "leave", "status",
			"registration_numbers_for_cars_with_colour", "slot_numbers_for_cars_with_colour",
			"slot_number_for_registration_number" };

	private boolean iscommandExist(String command) {

		for (int i = 0; i < commandList.length; i++) {
			if (command == commandList[i]) {
				return true;
			}
		}

		return false;

	}

	public void parseTextInput(String inputString) {

		String[] inputs = inputString.split(" ");
		if (inputs.length != 0 && !iscommandExist(inputs[0])) {
			if(!inputs[0].equals("create_parking_lot") && lotCreatedOrNot()) {
				return; 
			}
			switch (inputs[0]) {
			case "create_parking_lot":
				createParkingLot(Integer.parseInt(inputs[1]));
				break;
			case "park":
				parkingVehicle(inputs[1], inputs[2]);
				break;

			case "leave":
				leaveParkingSlot(Integer.parseInt(inputs[1]));
				break;

			case "status":
				statusOfParking();
				break;

			case "registration_numbers_for_cars_with_colour":
				registrationNoBasedonColor(inputs[1]);
				break;

			case "slot_numbers_for_cars_with_colour":
				slotNumberBasedonColor(inputs[1]);
				break;

			case "slot_number_for_registration_number":
				slotNumberBasedonRegistration(inputs[1]);
				break;

			}

		} else {
			System.out.println("Common not found");
		}
	}

	private void createParkingLot(int lotSize) {
		lot = new ParkingDetails[lotSize];
		System.out.println(String.format("Created a parking lot with %d slots", lot.length));
	}

	private void parkingVehicle(String registration, String color) {
		int slot = -1;
		for (int i = 0; i < lot.length; i++) {
			if (lot[i] == null) {
				slot = i;
				break;
			}
		}
		if (slot == -1) {
			System.out.println("Sorry, parking lot is full");
		} else {
			ParkingDetails parkingDetails = new ParkingDetails();
			parkingDetails.setRegistrationNo(registration);
			parkingDetails.setColor(color);
			parkingDetails.setSlotNumber(slot + 1);
			lot[slot] = parkingDetails;
			System.out.println(String.format("Allocated slot number %d", parkingDetails.getSlotNumber()));
		}

	}

	private void leaveParkingSlot(int slot) {
		boolean isvalidSlot = false;
		int freeSlot = 0;
		for (int i = 0; i < lot.length; i++) {
			freeSlot += lot[i] == null ? 1 : 0;
			if (lot[i] != null && lot[i].getSlotNumber() == slot) {
				lot[i] = null;
				System.out.println(String.format("Slot number %d is free", slot));
				isvalidSlot = true;
				break;
			}
		}
		if (freeSlot == lot.length) {
			System.out.println("Sorry,lot is empty");
			return;
		}
		if (!isvalidSlot) {
			System.out.println("Invalid slot number");

		}
	}

	private void statusOfParking() {
		System.out.println("Slot No.\tRegistration No.\tColor");
		for (int i = 0; i < lot.length; i++) {
			if (lot[i] != null) {
				System.out
						.println(lot[i].getSlotNumber() + "\t" + lot[i].getRegistrationNo() + "\t" + lot[i].getColor());

			}
		}
	}

	private void registrationNoBasedonColor(String color) {
		String registationNum = "";
		for (int i = 0; i < lot.length; i++) {
			if (lot[i] != null && lot[i].getColor().equalsIgnoreCase(color)) {
				registationNum += lot[i].getRegistrationNo() + ",";
			}
		}
		if (registationNum.trim().length() != 0) {
			System.out.println(registationNum.substring(0, registationNum.length() - 1));
		} else {
			System.out.println(String.format("Sorry, no car with this particular color %s", color));
		}
	}

	private void slotNumberBasedonColor(String color) {
		String registationNum = "";
		for (int i = 0; i < lot.length; i++) {
			if (lot[i] != null && lot[i].getColor().equalsIgnoreCase(color)) {
				registationNum += lot[i].getSlotNumber() + ",";
			}
		}
		if (registationNum.trim().length() != 0) {
			System.out.println(registationNum.substring(0, registationNum.length() - 1));
		} else {

			System.out.println(String.format("Sorry, no slotNo with this particular color %s", color));
		}
	}

	private void slotNumberBasedonRegistration(String registraionNumber) {
		boolean registationNum = false;
		for (int i = 0; i < lot.length; i++) {
			if (lot[i] != null && lot[i].getRegistrationNo().equalsIgnoreCase(registraionNumber)) {
				registationNum = true;
				System.out.println(lot[i].getSlotNumber());
			}
		}
		if (!registationNum) {
			System.out.println(
					String.format("Sorry, no slot No with this particular registration Number %s", registraionNumber));
		}
	}

	public int getLotSize() {
		return lot.length;
	}
	
	
	private boolean lotCreatedOrNot(){
		boolean lotIsEmpty=lot == null || lot.length == 0;
		if(lotIsEmpty) {
			
			System.out.println("Sorry, parking lot is not created");
			
		}
		return lotIsEmpty;
	}

}
