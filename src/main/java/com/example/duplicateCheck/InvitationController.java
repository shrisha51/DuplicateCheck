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
	private DuplicateCheckService service;
 
    @RequestMapping("/sendInvite")
    public Iterable<ResponseMatrix> greeting(@RequestParam(value="name", defaultValue="World") String name,@RequestParam(value="email", defaultValue="World") String email,@RequestParam(value="mobile", defaultValue="World") String mobile) {
       

        return service.checkDuplicate(name,email,mobile);
        
        //ResponseMatrix p5=new ResponseMatrix(counter.incrementAndGet(),"ASDASD",name,email,mobile,"SADASD","Something",1);
       // responseMatrixDAO.save(p5);
        	
      
    }
}