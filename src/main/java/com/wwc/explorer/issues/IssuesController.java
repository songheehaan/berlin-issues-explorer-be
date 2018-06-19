package com.wwc.explorer.issues;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.service.IssueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssuesController {
    @RequestMapping("/")
    public String index() {
        return "Stay tuned. This service will soon start serving github issues for opensource newbies.";
    }
    @RequestMapping("/issue")
    public String issue(){
        try {
            String result = "not set yet";
            IssuesService issuesService = new IssuesService();
            issuesService.allInOne();
        }catch (Exception e){
            e.printStackTrace();
        }
/*        try {
            IssuesService iS = new IssuesService();
            iS.gitAuth();
            PageIterator<Repository> repositoryPageIterator = iS.getGitRepo();
            result = iS.getGitIssue(repositoryPageIterator);
        }catch(Exception e){
            e.printStackTrace();
        }*/
        return "ABCDE";
    }
}
