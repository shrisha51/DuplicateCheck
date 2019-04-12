package com.example.duplicateCheck;


import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface InputMatrixDAO extends CrudRepository<InputMatrix, Long> {
 
    public List<InputMatrix> findByNameLike(String name);
    public List<InputMatrix> findByEmailLike(String email);
    public List<InputMatrix> findByMobileLike(String mobile);
    //public List<Person> findByDateOfBirthGreaterThan(Date date);
 
}
