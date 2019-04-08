package com.example.products;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
 
@Component
public class DataInit implements ApplicationRunner {
 
    private InputMatrixDAO inputMatrixDAO;
 
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 
    @Autowired
    public DataInit(InputMatrixDAO personDAO) {
        this.inputMatrixDAO = personDAO;
    }
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = inputMatrixDAO.count();
 
        if (count == 0) {
            InputMatrix p1 = new InputMatrix((long) 1,"john","john@sat.com","90909090");
            InputMatrix p2 = new InputMatrix((long) 2,"rohn","rohn@sat.com","9123456789");
            InputMatrix p5 = new InputMatrix((long) 3,"rohn","rohnis@sat.com","9123456789");
            InputMatrix p3 = new InputMatrix((long) 4,"rohn","rohnis@sat.com","something");
            InputMatrix p4 = new InputMatrix((long) 5,"rohn","rohn@sat.com","something");
//            p1.setName("John");
// 
//            Date d1 = df.parse("1980-12-20");
//            p1.setDateOfBirth(d1);
            //
//            Person p2 = new Person();
// 
//            p2.setFullName("Smith");
//            Date d2 = df.parse("1985-11-11");
//            p2.setDateOfBirth(d2);
 
            inputMatrixDAO.save(p1);
            inputMatrixDAO.save(p2);
            inputMatrixDAO.save(p3);
            inputMatrixDAO.save(p4);
            inputMatrixDAO.save(p5);
        }
 
    }
     
}