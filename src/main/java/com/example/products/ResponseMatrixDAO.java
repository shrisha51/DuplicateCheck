package com.example.products;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ResponseMatrixDAO extends CrudRepository<ResponseMatrix, Long> {
 
    public List<ResponseMatrix> findByNameLike(String name);
    public List<ResponseMatrix> findByContentLike(String content);
    public List<ResponseMatrix> findByEmailLike(String email);
    public List<ResponseMatrix> findByMobileLike(String mobile);
    public List<ResponseMatrix> findByMatchedOnLike(String matchedOn);
    public List<ResponseMatrix> findBySourceLike(String source);
}