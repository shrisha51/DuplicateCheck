package com.example.duplicateCheck;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuplicateCheckWithEditDistanceService {
	  
	@Autowired
  private InputMatrixDAO inputMatrixDAO;
	@Autowired
	private ResponseMatrixDAO responseMatrixDAO;
	@Autowired
	  private PartnerRepoDAO partnerRepoDAO;
	private final AtomicLong counter = new AtomicLong();
    

	public Iterable<ResponseMatrix> checkDuplicateWithEditDistance(String name, String email, String mobile) {
		
       
        StringBuilder sbi = new StringBuilder();
        duplicateCheckonListwed(name,email,mobile);
        Iterable<ResponseMatrix> response= responseMatrixDAO.findAll();
        return response;
	}
	
	private void duplicateCheckonListwed(String name, String email, String mobile) {

		
		
		Iterable<InputMatrix> iall = inputMatrixDAO.findAll(); 
		
		StringBuilder MatchedOn = new StringBuilder();
		 
		 iall.forEach(p ->
	        {
	        	boolean matched=false;
	        	int Strength=0;
	        	int DistName=EditDistDP(p.getName(),name);
	        	if(DistName<Math.sqrt(name.length())) {
	        		matched=true;	
	        		MatchedOn.append("-Name");
	        		Strength+=1;
	        	}
	        	int DistMob=EditDistDP(p.getMobile(),mobile);
	        	if(DistMob<Math.sqrt(mobile.length())) {
	        		matched=true;	
	        		MatchedOn.append("-Mobile");
	        		Strength+=3;
	        	}
	        	int DistEmail=EditDistDP(p.getEmail(),email);
	        	if(DistEmail<Math.sqrt(email.length())) {
	        		matched=true;	
	        		MatchedOn.append("-Email");
	        		Strength+=5;
	        	}
	        	if(matched) {
	        	ResponseMatrix p5=new ResponseMatrix(counter.incrementAndGet(),p.getName(),p.getEmail(),p.getMobile(),"Prior Invitation Fuzzy Search","",MatchedOn.toString(),Strength);
	        	//sbi.append(p.getName() + "<br>");
	        	responseMatrixDAO.save(p5);
	        	matched=false;
	        	Strength=0;
	        	MatchedOn.setLength(0);
	        	}
	        });
		 Iterable<PartnerRepo> pall = partnerRepoDAO.findAll(); 
			
			StringBuilder MatchedOn1 = new StringBuilder();
			 
			 pall.forEach(p ->
		        {
		        	boolean matched=false;
		        	int Strength=0;
		        	int DistName=EditDistDP(p.getName(),name);
		        	if(DistName<Math.sqrt(name.length())) {
		        		matched=true;	
		        		MatchedOn1.append("-Name("+DistName+")");
		        		Strength+=1;
		        	}
		        	int DistMob=EditDistDP(p.getMobile(),mobile);
		        	if(DistMob<Math.sqrt(mobile.length())) {
		        		matched=true;	
		        		MatchedOn1.append("-Mobile("+DistMob+")");
		        		Strength+=3;
		        	}
		        	int DistEmail=EditDistDP(p.getEmail(),email);
		        	if(DistEmail<Math.sqrt(email.length())) {
		        		matched=true;	
		        		MatchedOn1.append("-Email("+DistEmail+")");
		        		Strength+=5;
		        	}
		        	if(matched) {
		        	ResponseMatrix p5=new ResponseMatrix(counter.incrementAndGet(),p.getName(),p.getEmail(),p.getMobile(),"Partner Repository Fuzzy Search",p.getNetworkId(),MatchedOn1.toString(),Strength);
		        	responseMatrixDAO.save(p5);
		        	matched=false;
		        	Strength=0;
		        	MatchedOn1.setLength(0);
		        	}
		        });
	}
	private int EditDistDP(String str1, String str2) {
			int m=str1.length();
			int n=str2.length();
	        // Create a table to store results of subproblems 
	        int dp[][] = new int[m+1][n+1]; 
	       
	        // Fill d[][] in bottom up manner 
	        for (int i=0; i<=m; i++) 
	        { 
	            for (int j=0; j<=n; j++) 
	            { 
	                // If first string is empty, only option is to 
	                // insert all characters of second string 
	                if (i==0) 
	                    dp[i][j] = j;  // Min. operations = j 
	       
	                // If second string is empty, only option is to 
	                // remove all characters of second string 
	                else if (j==0) 
	                    dp[i][j] = i; // Min. operations = i 
	       
	                // If last characters are same, ignore last char 
	                // and recur for remaining string 
	                else if (str1.charAt(i-1) == str2.charAt(j-1)) 
	                    dp[i][j] = dp[i-1][j-1]; 
	       
	                // If the last character is different, consider all 
	                // possibilities and find the minimum 
	                else
	                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert 
	                                       dp[i-1][j],  // Remove 
	                                       dp[i-1][j-1]); // Replace 
	            } 
	        } 
	   
	        return dp[m][n]; 
	    } 
	
	static int min(int x,int y,int z) 
    { 
        if (x <= y && x <= z) return x; 
        if (y <= x && y <= z) return y; 
        else return z; 
    } 
	
}
