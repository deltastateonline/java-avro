package com.deltastateonline.avro.no;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;


public class Avroreader {
	
	
	public static void main(String args[]) throws Exception{
		
	      //Instantiating the Schema.Parser class.
	      Schema schema = new Schema.Parser().parse(new File("schema\\Emp.avsc"));
	      DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
	      DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(new File("data\\employee.no.txt"), datumReader);
	      GenericRecord emp = null;
			
	      while (dataFileReader.hasNext()) {
	         emp = dataFileReader.next(emp);
	         System.out.println(emp);
	      }
	   }

}
