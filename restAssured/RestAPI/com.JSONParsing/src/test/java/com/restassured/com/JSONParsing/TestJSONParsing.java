package com.restassured.com.JSONParsing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJSONParsing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] jsonData=Files.readAllBytes(Paths.get("E:\\Sampada\\Infostride\\com.JSONParsing\\empdata.json"));
		ObjectMapper mapper=new ObjectMapper();
		
		Person person=mapper.readValue(jsonData, Person.class);
		
		System.out.println(person.getEmail());
		System.out.println(person.getAddress().getCountry());
		
	}

}
