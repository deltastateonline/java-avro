package com.aamc.applications;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;


public class Appreader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	      //DeSerializing the objects
	      DatumReader<AamcApplication> dataDatumReader = new SpecificDatumReader<AamcApplication>(AamcApplication.class);
			
	      //Instantiating DataFileReader
	      DataFileReader<AamcApplication> dataFileReader;
		try {
			dataFileReader = new DataFileReader<AamcApplication>(new
			     File("data\\aamc.applications.avro"), dataDatumReader);
			
			  AamcApplication em=null;
				
		      while(dataFileReader.hasNext()){
		      
		         em=dataFileReader.next(em);
		         System.out.println(em);
		      }
		      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     

	}

}
