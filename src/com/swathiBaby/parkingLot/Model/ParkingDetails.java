package com.swathiBaby.parkingLot.Model;

public class ParkingDetails {
	
		private String	registrationNo;
		private String	color;
		private int slotNumber;
		
		
		
		public ParkingDetails() {
		
		}
		public ParkingDetails(String registrationNo, String color, int slotNumber) {
			this.registrationNo = registrationNo;
			this.color = color;
			this.slotNumber = slotNumber;
		}
		public String getRegistrationNo() {
			return registrationNo;
		}
		public void setRegistrationNo(String registrationNo) {
			this.registrationNo = registrationNo;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getSlotNumber() {
			return slotNumber;
		}
		public void setSlotNumber(int slotNumber) {
			this.slotNumber = slotNumber;
		}
		
}
