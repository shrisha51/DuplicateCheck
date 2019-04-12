package com.example.duplicateCheck;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvitationController {
	  
	@Autowired
    private InputMatrixDAO inputMatrixDAO;
	@Autowired
	private ResponseMatrixDAO responseMatrixDAO;
	@Autowired
	private DuplicateCheckService service;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    

    @RequestMapping("/sendInvite")
    public Iterable<ResponseMatrix> greeting(@RequestParam(value="name", defaultValue="World") String name,@RequestParam(value="email", defaultValue="World") String email,@RequestParam(value="mobile", defaultValue="World") String mobile) {
//        return new InputMatrix(
//                            String.format(template, name),String.format(template, email),String.format(template, mobile));

//    	Iterable<InputMatrix> iall = inputMatrixDAO.findAll();
//        StringBuilder MatchedOn = new StringBuilder();
//        StringBuilder sbi = new StringBuilder();
//        
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

        return service.checkDuplicate(name,email,mobile);
        
       // InputMatrix inp=new InputMatrix(counter.incrementAndGet(),name,email,mobile);
        //ResponseMatrix p5=new ResponseMatrix(counter.incrementAndGet(),"ASDASD",name,email,mobile,"SADASD","Something",1);
        //inputMatrixDAO.save(inp);
       // responseMatrixDAO.save(p5);
        	
        
        //sb.append(sbi.toString());
    	//return new ResponseMatrix(counter.incrementAndGet(),"ASDASD",name,email,mobile,"SADASD",MatchedOn.toString(),1);
//        Iterable<ResponseMatrix> response= responseMatrixDAO.findAll();
//        return response;
    }
}