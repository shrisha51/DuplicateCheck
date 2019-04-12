package com.example.duplicateCheck;


import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface PartnerRepoDAO extends CrudRepository<PartnerRepo, Long> {
 
    public List<PartnerRepo> findByNameLike(String name);
    public List<PartnerRepo> findByEmailLike(String email);
    public List<PartnerRepo> findByMobileLike(String mobile);
    public List<PartnerRepo> findByNetworkIdLike(String networkId);
    //public List<Person> findByDateOfBirthGreaterThan(Date date);
 
}

