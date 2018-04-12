package com.wwc.explorer.issues;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;

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
//	private static final String GET_URL = "https://api.github.com/zen";
	private static final String GET_URL ="-i https://api.github.com/users/defunkt";

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

    public static void javaApi(){
        try {
/*            GitHubClient client = new GitHubClient();
            client.setCredentials("user", "passw0rd");*/

            //OAuth2 token authentication
            GitHubClient client = new GitHubClient();
            client.setOAuth2Token("enter personal access token");

            RepositoryService service = new RepositoryService();
            for (Repository repo : service.getRepositories("defunkt")) //https://github.com/defunkt?tab=repositories
                System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}





//
//    @RequestMapping(value ="/",produces = "application/json")
//    public String getURLValue(HttpServletRequest request){
//        String test = request.getRequestURI();
//        return test;
//    }
