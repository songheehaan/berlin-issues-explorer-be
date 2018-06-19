package com.wwc.explorer.issues;

import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.SearchIssue;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssuesService {
    //w/o library
    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl = "";
    ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl + "/1", String.class);
    assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));




    private static GitHubClient client;
    public static void allInOne()throws IOException{
        //Basic authentication
        client = new GitHubClient();
        client.setOAuth2Token("");
        RepositoryService repositoryService = new RepositoryService();
        PageIterator<Repository> repositoryPageIterator = repositoryService.pageAllRepositories();
        IssueService issueService = new IssueService();

        Collection<Repository> repositoryCollection = repositoryPageIterator.next();
        System.out.println("collection size "+ repositoryCollection.size());

        ArrayList<Repository> repositoryArrayList = ((ArrayList<Repository>) repositoryCollection);
        System.out.println("array size "+ repositoryArrayList.size());

        for(int i=0;i<10;i++){
            List<SearchIssue> searchIssueList = issueService.searchIssues(repositoryArrayList.get(i), IssueService.STATE_OPEN, "label:beginner friendly");
            System.out.println("result??? "+searchIssueList.get(i).getHtmlUrl());
        }
    }
    public static void gitAuth(){
        //Basic authentication
        client = new GitHubClient();
        client.setOAuth2Token("");
    }
    public static PageIterator<Repository> getGitRepo(){
        RepositoryService repositoryService = new RepositoryService();
        PageIterator<Repository> repositoryPageIterator = repositoryService.pageAllRepositories();
        return repositoryPageIterator;
    }
    public static String getGitIssue(PageIterator<Repository> repositoryPageIterator)throws IOException{
        IssueService issueService = new IssueService();

        Collection<Repository> repositoryCollection = repositoryPageIterator.next();
        System.out.println("collection size "+ repositoryCollection.size());
        ArrayList<Repository> repositoryArrayList = ((ArrayList<Repository>) repositoryCollection);
        System.out.println("array size "+ repositoryArrayList.size());

        for(int i=0;i<10;i++){
            List<SearchIssue> searchIssueList = issueService.searchIssues(repositoryArrayList.get(i), IssueService.STATE_OPEN, "label:beginner friendly");
            System.out.println("result??? "+searchIssueList.get(i).getHtmlUrl());
        }

/*        for(Repository repo :repositoryArrayList) {
            List<SearchIssue> searchIssueList = issueService.searchIssues(repo, IssueService.STATE_OPEN, "label:beginner friendly");
            for (SearchIssue searchIssue:searchIssueList) {
                String result = "title: " + searchIssue.getTitle() + "\n" + "User: " + searchIssue.getUser() + "\n" + "url: " + searchIssue.getHtmlUrl();
                System.out.println(result);
            }
        }*/
        return "running!!!";
    }

/*
    // connect to Git API
	private static final String USER_AGENT = "Mozilla/5.0";	private static final String GET_URL = "https://api.github.com/zen";
	private static final String GET_URL ="-i https://api.github.com/users/defunkt";

	public static RestTemplate  rt = new RestTemplate();

    public static String resourceUrl = "https://api.github.com/users/defunkt";
    public static IssuesModel im;
    //Class RestTemplate
    public static void getReq(){
//       rt.exchange("-i https://api.github.com/users/defunkt", HttpMethod.GET,null,String.class);
        ResponseEntity<String> response = rt.getForEntity(resourceUrl,String.class);
        System.out.println("dfdfdf"+response.getBody());
    }


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
*/


/*
    public static void connectTGitHub(){
        GitHubClient client = new GitHubClient();
        client.setOAuth2Token("enter personal access token");

    }
    public static void javaApi(){
        try {
*/
/*          //Basic authentication
            GitHubClient client = new GitHubClient();
            client.setCredentials("user", "password");*//*


            //OAuth2 token authentication
            GitHubClient client = new GitHubClient();
            client.setOAuth2Token("");

            org.eclipse.egit.github.core.service.IssuesService issueS = new org.eclipse.egit.github.core.service.IssuesService();

            RepositoryService service = new RepositoryService();
            for (Repository repo : service.getRepositories("defunkt")) { //https://github.com/defunkt?tab=repositories
                System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
                issueS.getIssues();
            }        }catch(Exception e){
            e.printStackTrace();
        }
    }
*/

/*
    public static ArrayList<String> allRepositories(){
        ArrayList<String> al = new ArrayList<>();
        try {
            RepositoryService rs = new RepositoryService();
            PageIterator<Repository> pir = rs.pageAllRepositories();
            while(pir.hasNext()) {
                for (Repository r : pir.next()) {
                    String s = "repo name [" + r.getName() + "]\n"
                            + "repo git language [" + r.getLanguage() + "] \n"
                            + "repo git description [" + r.getDescription() + "] \n"
                            + "repo git Url [" + r.getGitUrl() + "] \n";
                    al.add(s);
                }
            }
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("labels","basic functionality");
            hm.put("labels","beginner friendly");

            org.eclipse.egit.github.core.service.IssuesService is = new org.eclipse.egit.github.core.service.IssuesService();
            List<Issue> li = is.getIssues(ra[0], hm);
            System.out.println(li.get(0).getLabels());
            System.out.println(li.get(0).getUser());

        }catch(Exception e){
            e.printStackTrace();
        }
        return al;
    }
*/

}
