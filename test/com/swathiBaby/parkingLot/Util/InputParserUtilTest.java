package com.swathiBaby.parkingLot.Util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserUtilTest {
	InputParserUtil testing = new InputParserUtil();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void cleanUpStreams() {
		System.setOut(originalOut);
	}

	@Test
	void createParkingLotTest() {
		testing.parseTextInput("create_parking_lot 6");
		assertTrue(6 == testing.getLotSize());
		assertEquals("Createdaparkinglotwith6slots", outContent.toString().trim().replace(" ", ""));
		testing.parseTextInput("create_parking_lot 5");
		assertFalse(4 == testing.getLotSize());
	}

	@Test
	void parkingVehicleTest() {
		testing.parseTextInput("park KA-01-HH-9999 White");
		assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("create_parking_lot 1");
		assertEquals("Createdaparkinglotwith1slots", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("park KA-01-HH-9999 White");
		assertEquals("Allocatedslotnumber1", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("park KA01HH9998 White");
		assertEquals("Sorry,parkinglotisfull", outContent.toString().trim().replace(" ", ""));
	}

	@Test
	void leaveParkingSlotTest() {
		testing.parseTextInput("park KA-01-HH-9999 White");
		assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("create_parking_lot 1");
		assertEquals("Createdaparkinglotwith1slots", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("park KA-01-HH-9932 White");
		assertEquals("Allocatedslotnumber1", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("leave 8");
		assertEquals("Invalidslotnumber", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("leave 1");
		assertEquals("Slotnumber1isfree", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("leave 1");
		assertEquals("Sorry,lotisempty", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
	}

	@Test
	void registrationNoBasedonColor() {
		testing.parseTextInput("park KA-01-HH-9999 White");
		assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("create_parking_lot 2");
		assertEquals("Createdaparkinglotwith2slots", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("park KA-01-HH-9932 White");
		assertEquals("Allocatedslotnumber1", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("park KA-01-HH-9933 White");
		assertEquals("Allocatedslotnumber2", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("registration_numbers_for_cars_with_colour white");
		assertEquals("KA-01-HH-9932,KA-01-HH-9933", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
		testing.parseTextInput("registration_numbers_for_cars_with_colour red");
		assertEquals("Sorry,nocarwiththisparticularcolorred", outContent.toString().trim().replace(" ", ""));
		outContent.reset();
	}
	
	
	

}
