package com.swathiBaby.parkingLot.ServiceImple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.swathiBaby.parkingLot.Service.ParkingDetailsService;
import com.swathiBaby.parkingLot.Util.InputParserUtil;

public class CommandPromptBasedInterpretor implements ParkingDetailsService {

	@Override
	public void start() {
		/*System.out.println("Implementation type : "+CommandPromptBasedInterpretor.class.getName());*/
		  System.out.println("Please enter 'exit' to quit");
          System.out.println("Waiting for input...\n\n");
          
		
		 for (;;) {
             try {
            	 
                 BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                 String inputString = bufferRead.readLine();
                 if (inputString.equalsIgnoreCase("exit")) {
                     break;
                 } else if ((inputString == null) || (inputString.isEmpty())) {
                     // Do nothing
                 } else {
                     InputParserUtil.parseTextInput(inputString.trim());
                     System.out.println("Please enter 'exit' to quit");
                     System.out.println("Waiting for input...\n\n");
                 }
                 
             } catch(IOException e) {
                 System.out.println("Oops! Error in reading the input from console.");
                 e.printStackTrace();
             }
         }
	}

}
