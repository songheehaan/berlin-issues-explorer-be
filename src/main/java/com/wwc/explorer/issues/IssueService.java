package com.wwc.explorer.issues;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class IssueService {
    // connect to Git API
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String GET_URL = "https://api.github.com/zen";

    public static String sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        String result = "";
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            result = response.toString();
        } else {
            result = "GET request not worked";
        }
        return  result;
    }

}





//
//    @RequestMapping(value ="/",produces = "application/json")
//    public String getURLValue(HttpServletRequest request){
//        String test = request.getRequestURI();
//        return test;
//    }
