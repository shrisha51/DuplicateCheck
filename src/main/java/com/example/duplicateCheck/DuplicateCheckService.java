package com.example.duplicateCheck;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuplicateCheckService {
	  
	@Autowired
  private InputMatrixDAO inputMatrixDAO;
	@Autowired
	private ResponseMatrixDAO responseMatrixDAO;
	@Autowired
	  private PartnerRepoDAO partnerRepoDAO;
	private final AtomicLong counter = new AtomicLong();
    

	public Iterable<ResponseMatrix>  checkDuplicate(String name, String email, String mobile) {
		
       
        StringBuilder sbi = new StringBuilder();
        duplicateCheckonList(false,name,email,mobile);
        
//        iall.forEach(p ->
//        {
//        	boolean matched=false;
//        	int Strength=0;
//        	if(p.getName().equalsIgnoreCase(name)) {
//        		matched=true;	
//        		MatchedOn.append("-Name");
//        		Strength+=1;
//        	}
//        	if(p.getMobile().equalsIgnoreCase(mobile)) {
//        		matched=true;	
//        		MatchedOn.append("-Mobile");
//        		Strength+=3;
//        	}
//        	if(p.getEmail().equalsIgnoreCase(email)) {
//        		matched=true;	
//        		MatchedOn.append("-Email");
//        		Strength+=5;
//        	}
//        	if(matched) {
//        	ResponseMatrix p5=new ResponseMatrix(counter.incrementAndGet(),p.getName(),p.getEmail(),p.getMobile(),"Prior Invitation","",MatchedOn.toString(),Strength);
//        	//sbi.append(p.getName() + "<br>");
//        	responseMatrixDAO.save(p5);
//        	matched=false;
//        	Strength=0;
//        	MatchedOn.setLength(0);
//        	}
//        });
        
        Iterable<ResponseMatrix> response= responseMatrixDAO.findAll();
        return response;
	}
	
	private void duplicateCheckonList(boolean fromRepo,String name, String email, String mobile) {
		
		Iterable<InputMatrix> iall = inputMatrixDAO.findAll(); 
		
		StringBuilder MatchedOn = new StringBuilder();
		 
		 iall.forEach(p ->
	        {
	        	boolean matched=false;
	        	int Strength=0;
	        	if(p.getName().equalsIgnoreCase(name)) {
	        		matched=true;	
	        		MatchedOn.append("-Name");
	        		Strength+=1;
	        	}
	        	if(p.getMobile().equalsIgnoreCase(mobile)) {
	        		matched=true;	
	        		MatchedOn.append("-Mobile");
	        		Strength+=3;
	        	}
	        	if(p.getEmail().equalsIgnoreCase(email)) {
	        		matched=true;	
	        		MatchedOn.append("-Email");
	        		Strength+=5;
	        	}
	        	if(matched) {
	        	ResponseMatrix p5=new ResponseMatrix(counter.incrementAndGet(),p.getName(),p.getEmail(),p.getMobile(),"Prior Invitation","",MatchedOn.toString(),Strength);
	        	//sbi.append(p.getName() + "<br>");
	        	responseMatrixDAO.save(p5);
	        	matched=false;
	        	Strength=0;
	        	MatchedOn.setLength(0);
	        	}
	        });
	}
}
