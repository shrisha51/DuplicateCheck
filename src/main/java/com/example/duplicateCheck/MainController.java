package com.example.duplicateCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@Autowired
    private InputMatrixDAO inputMatrixDAO;
	@Autowired
	private ResponseMatrixDAO responseMatrixDAO;
	
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

}
