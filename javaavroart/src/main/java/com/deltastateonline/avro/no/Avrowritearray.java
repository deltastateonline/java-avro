package com.deltastateonline.avro.no;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;

public class Avrowritearray {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//Instantiating the Schema.Parser class.
	      Schema schema = new Schema.Parser().parse(new File("schema\\Empcollection.avsc"));
			
	      //Instantiating the GenericRecord class.
	      GenericRecord e1 = new GenericData.Record(schema);
	      
	      
	      GenericRecord CourseRec = new GenericData.Record(schema.getField("course_details").schema());
			
	      
	      
	      
	     // e1.put("Empcollection", empData);
	      
	      
	      
	      
	      DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>(schema);
			
	      DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
	      dataFileWriter.create(schema, new File("data\\employee.list.no.txt"));
			
	      dataFileWriter.append(e1);
	     // dataFileWriter.append(e2);
	      dataFileWriter.close();
		
	      System.out.println("data successfully serialized");	
	}
	

}
