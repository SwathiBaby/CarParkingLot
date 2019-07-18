package com.swathiBaby.parkingLot.ServiceImple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.swathiBaby.parkingLot.Service.ParkingDetailsService;
import com.swathiBaby.parkingLot.Util.InputParserUtil;

public class FileBasedInterpreter  implements ParkingDetailsService{
    String filePath=null;
    File inputFile =null; 
	public FileBasedInterpreter(String filePath) throws NullPointerException {
		if(filePath==null || filePath.trim().length()==0) {
			throw new NullPointerException("File Cannot be null or empty");
		}
	  this.filePath = filePath;
	  inputFile= new File(filePath);
	 }

	@Override
	public void start() {
		System.out.println("Implementation type : "+FileBasedInterpreter.class.getName());
		InputParserUtil testing = new InputParserUtil();
		
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(inputFile));
	            String line;
	            try {
	                while ((line = br.readLine()) != null) {
	                	testing.parseTextInput(line.trim());
	                }
	            } catch (IOException ex) {
	                System.out.println("Error in reading the input file.");
	                ex.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found in the path specified.");
	            e.printStackTrace();
	        }
		
	}

	
	
	
}
