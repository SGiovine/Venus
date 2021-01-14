package it.objectmethod.srlgroupjob.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CSVbuilderTest {

	CSVbuilder builder;

	OutputStream outStream;

	List<String[]> csvParametersList = new ArrayList<String[]>();

	@Before
	public void setup() throws Exception {

		outStream = new ByteArrayOutputStream();

		builder = new CSVbuilder();

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCsvBuilder() {

	//	String[] strs = { "ciao", "come", "va", ",", "spero", "tutto", "bene", "." };

		String[] strs2 = { "ciao2", "come2", "v2a", ",2", "spe2ro", "tu2tto", "ben2e", "2." };
		
	//	csvParametersList.add(strs);
		csvParametersList.add(strs2);

		builder.csvBuilder(csvParametersList,outStream);

		ByteArrayOutputStream outStream2 = (ByteArrayOutputStream) outStream;
		
		 System.err.print("well = "+new String(outStream2.toByteArray()));		
		assertNotEquals("", new String(outStream2.toByteArray()));
	}

}
