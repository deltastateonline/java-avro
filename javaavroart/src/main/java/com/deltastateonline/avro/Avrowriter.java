package com.deltastateonline.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;


/**
 * Hello world!
 *
 */
public class Avrowriter 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Emp e1 = new Emp();
        
        e1.setName("Omokhoa");
        e1.setAge(43);        
        e1.setSalary(60000);
        e1.setAddress("Brendale");
        e1.setId(001);
        
        
        Emp e2=new Emp();
    	
        e2.setName("Kristy Agbagabra");
        e2.setAge(40);
        e2.setSalary(40000);
        e2.setAddress("Kallangur");
        e2.setId(002);
  	
        Emp e3=new Emp();
  	
        e3.setName("Leyton");
        e3.setAge(12);
        e3.setSalary(35000);
        e3.setAddress("Murrumba Down");
        e3.setId(003);
        
        
        Emp e4=new Emp();
      	
        e4.setName("Dylan");
        e4.setAge(11);
        e4.setSalary(30000);
        e4.setAddress("Mango Hill");
        e4.setId(004);
        
        //Instantiate DatumWriter class
        DatumWriter<Emp> empDatumWriter = new SpecificDatumWriter<Emp>(Emp.class);
        DataFileWriter<Emp> empFileWriter = new DataFileWriter<Emp>(empDatumWriter);
  	
        try {
			empFileWriter.create(e1.getSchema(), new File("data\\employee.avro"));
			
			empFileWriter.append(e1);
	        empFileWriter.append(e2);
	        empFileWriter.append(e3);
	        empFileWriter.append(e4);
	  	
	        empFileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
      
  	
        System.out.println("data successfully serialized");
        
        
    }
}
