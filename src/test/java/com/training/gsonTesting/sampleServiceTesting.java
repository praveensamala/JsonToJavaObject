package com.training.gsonTesting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.training.datastructures.*;

public class sampleServiceTesting {
	public static void main(String args[])
	{	
		/*sampleServiceObject ss = new sampleServiceObject();
		ss.setCountry("india");
		ss.setRegion("asia");
		ss.setQuantity("100 billion");
		
		Gson gson = new Gson();
		String gsonString = gson.toJson(ss);
		System.out.println("gsonString : "+gsonString);*/
		
		try{
			FileReader fr = new FileReader(System.getProperty("user.dir") + "/json/sampleservice.json");
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/json/sampleservice.json"));
			String text = "";
			String line=br.readLine();
			while (line!=null) {
				text+=line;
				line=br.readLine();
			}
			System.out.println("json : "+text);
			
			Gson gson = new Gson();
			sampleServiceObject sso = gson.fromJson(text, sampleServiceObject.class);
			Items temp =sso.getItems(); 
					
			//gson.fromJson(sso.getItems().toString(), Items.class);
			
			System.out.println("sso id      : "+temp.getId());
			System.out.println("sso country : "+sso.getCountry());
			System.out.println("sso region  : "+sso.getRegion());
			System.out.println("sso timeout : "+sso.getTimeout());
		}
		catch (Exception e) {
			System.out.println("received exception while reading the file");
		}
		
	}
}
