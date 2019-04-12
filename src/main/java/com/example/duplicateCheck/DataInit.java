package com.example.duplicateCheck;

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
    private PartnerRepoDAO partnerRepoDAO;
 
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 
    @Autowired
    public DataInit(InputMatrixDAO personDAO,PartnerRepoDAO partnerRepoDAO) {
        this.inputMatrixDAO = personDAO;
        this.partnerRepoDAO = partnerRepoDAO;
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
            PartnerRepo r1 = new PartnerRepo((long) 1,"john","john@sat.com","90909090","101010010");
            PartnerRepo r2 = new PartnerRepo((long) 2,"rohn","rohn@sat.com","9123456789","202020202");
            PartnerRepo r5 = new PartnerRepo((long) 3,"rohn","rohnis@sat.com","9123456789","303030303");
            PartnerRepo r3 = new PartnerRepo((long) 4,"rohn","rohnis@sat.com","something","4040404040");
            PartnerRepo r4 = new PartnerRepo((long) 5,"rohn","rohn@sat.com","something","5005050505");
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
            partnerRepoDAO.save(r1);
            partnerRepoDAO.save(r2);
            partnerRepoDAO.save(r3);
            partnerRepoDAO.save(r4);
            partnerRepoDAO.save(r5);
        }
 
    }
     
}