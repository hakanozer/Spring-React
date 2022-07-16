package com.works.repositories;

import com.works.entities.JoinProCat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinProCatRepository extends JpaRepository<JoinProCat, Integer> {

    @Query(value = "SELECT COUNT(*) as size FROM product as p INNER JOIN category as c ON p.cid = c.cid", nativeQuery = true)
    int totalSize();

    @Query(value = "SELECT p.pid, p.cid, p.price, p.ptitle, c.title FROM product as p INNER JOIN category as c ON p.cid = c.cid", nativeQuery = true)
    List<JoinProCat> allProduct();

    @Query(value = "SELECT p.pid, p.cid, p.price, p.ptitle, c.title FROM product as p INNER JOIN category as c ON p.cid = c.cid WHERE p.ptitle LIKE ?1 ", nativeQuery = true)
    List<JoinProCat> searchProduct( String q );

    @Query(value = "SELECT p.pid, p.cid, p.price, p.ptitle, c.title FROM product as p INNER JOIN category as c ON p.cid = c.cid limit ?1, ?2", nativeQuery = true)
    List<JoinProCat> pageProduct( int start, int count );

    @Query(value = "SELECT p.pid, p.cid, p.price, p.ptitle, c.title FROM product as p INNER JOIN category as c ON p.cid = c.cid WHERE p.ptitle LIKE ?1", nativeQuery = true)
    List<JoinProCat> findAllPage(String q, Pageable pageable);
    @Query(value = "SELECT count(*) as total FROM product as p INNER JOIN category as c ON p.cid = c.cid WHERE p.ptitle LIKE ?1", nativeQuery = true)
    int countTotal(String ptitle);




}