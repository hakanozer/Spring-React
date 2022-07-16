package com.works.repositories;

import com.works.entities.JoinProCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinProCatRepository extends JpaRepository<JoinProCat, Integer> {

    @Query(value = "SELECT p.pid, p.cid, p.price, p.ptitle, c.title FROM product as p INNER JOIN category as c ON p.cid = c.cid", nativeQuery = true)
    List<JoinProCat> allProduct();

}