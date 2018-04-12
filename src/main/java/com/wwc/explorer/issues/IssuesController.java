package com.wwc.explorer.issues;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class IssuesController {
    @RequestMapping("/")
    public String index() {
        return "Stay tuned. This service will soon start serving github issues for opensource newbies.";
    }
    @RequestMapping("/issue")
    public void issue(){
        IssueService iS = new IssueService();
        iS.javaApi();

        /*        String result = "";
        try {
            result = iS.sendGET();
        }catch(IOException ioe){
            ioe.getStackTrace();
        }
        return result;*/
    }
}
