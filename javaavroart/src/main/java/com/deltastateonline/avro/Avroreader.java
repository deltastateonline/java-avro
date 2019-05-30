package com.deltastateonline.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

public class Avroreader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	      //DeSerializing the objects
	      DatumReader<Emp> empDatumReader = new SpecificDatumReader<Emp>(Emp.class);
			
	      //Instantiating DataFileReader
	      DataFileReader<Emp> dataFileReader;
		try {
			dataFileReader = new DataFileReader<Emp>(new
			     File("data\\employee.avro"), empDatumReader);
			
			 Emp em=null;
				
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
