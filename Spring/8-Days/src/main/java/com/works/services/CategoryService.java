package com.works.services;

import com.works.entities.Category;
import com.works.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CategoryService {

    final CategoryRepository cRepo;
    public CategoryService(CategoryRepository cRepo) {
        this.cRepo = cRepo;
    }

    public ResponseEntity save(Category category) {
        Map<String, Object> hm = new LinkedHashMap<>();
        cRepo.save( category );
        hm.put("status", true);
        hm.put("result", category);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity list() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", cRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
