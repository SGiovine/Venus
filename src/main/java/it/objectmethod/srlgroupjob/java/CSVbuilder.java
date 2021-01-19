package it.objectmethod.srlgroupjob.java;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CSVbuilder {

	public void csvBuilder(List<String[]> csvParametersList,OutputStream outstream) {
		
		String csvOutput = "";
		
		for (String[] csvParameters : csvParametersList) {
			for (String param: csvParameters) {
				if (param == null||param.trim().equals("")) {
					param = "campo_vuoto";
				}
					csvOutput += param + ",";
			}
			csvOutput = csvOutput.substring(0,csvOutput.length()-1);
			csvOutput +="\n";
		}
		try {
			outstream.write(csvOutput.getBytes());
			outstream.flush();
			outstream.close();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
