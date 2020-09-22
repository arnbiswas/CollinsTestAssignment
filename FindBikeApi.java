package com.testcode;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class FindBikeApi {
	public static void main(String[] args) {

		String inline = "";

		try {
			System.out.println("Enter City Name:");
			Scanner sc1 = new Scanner(System.in);
			String nameCity = sc1.next();
			sc1.close();
			URL url = new URL("http://api.citybik.es/v2/networks");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);


			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}

				sc.close(); 
			} 


			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject) parse.parse(inline);

			JSONArray jsonarr_1 = (JSONArray) jobj.get("networks");
			boolean found = false;
			for (int i = 0; i < jsonarr_1.size(); i++) {

				JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
				
				JSONObject jlocation = (JSONObject) jsonobj_1.get("location");
				if (nameCity.equalsIgnoreCase(jlocation.get("city").toString()))
						{
				System.out.println("Elements under results array");
				System.out.println("City: " + jlocation.get("city"));
				System.out.println("Country: " + jlocation.get("country"));
				System.out.println("Latitude: " + jlocation.get("latitude"));
				System.out.println("longitude: " + jlocation.get("longitude"));
				System.out.println("company: " + jsonobj_1.get("company"));
				System.out.println("href: " + jsonobj_1.get("href"));
				System.out.println("name: " + jsonobj_1.get("name"));
				System.out.println("id: " + jsonobj_1.get("id") + "\n");
				found = true;
				break;
						}
				
			}
			if (found == false) {
				System.out.println("City not found");
			}
			// Disconnect the HttpURLConnection stream
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}