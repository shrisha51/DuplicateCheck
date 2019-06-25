package com.example.duplicateCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
	@Autowired
    private InputMatrixDAO inputMatrixDAO;
	@Autowired
	private ResponseMatrixDAO responseMatrixDAO;
	@Autowired
	private DuplicateCheckWithEditDistanceService serviceED;
  @RequestMapping("/")
  @ResponseBody
  public String index() {
	  StringBuilder sb = new StringBuilder();
      Iterable<InputMatrix> iall = inputMatrixDAO.findAll();
      
      StringBuilder sbi = new StringBuilder();

      iall.forEach(p -> sbi.append(p.getName() + "<br>"));

      sb.append(sbi.toString());
      Iterable<ResponseMatrix> rall = responseMatrixDAO.findAll();
      
      StringBuilder sbr = new StringBuilder();

      rall.forEach(p -> sbr.append(p.getName() + "<br>"));
sb.append(sbr.toString());
   sb.append("\n the end");
      return sb.toString();
  }

  @RequestMapping("/sendInviteFuzzySearchForDuplicateCheck")
  @ResponseBody
  public Iterable<ResponseMatrix> FuzzySearch(@RequestParam(value="name", defaultValue="World") String name,@RequestParam(value="email", defaultValue="World") String email,@RequestParam(value="mobile", defaultValue="World") String mobile) {
     

      return serviceED.checkDuplicateWithEditDistance(name,email,mobile);
      
      //ResponseMatrix p5=new ResponseMatrix(counter.incrementAndGet(),"ASDASD",name,email,mobile,"SADASD","Something",1);
     // responseMatrixDAO.save(p5);
      	
    
  }
}
