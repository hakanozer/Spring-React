package com.works.restcontrollers;

import com.works.entities.Category;
import com.works.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

    final CategoryService cService;
    public CategoryRestController(CategoryService cService) {
        this.cService = cService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Category category) {
        return cService.save( category );
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return cService.list();
    }

}
