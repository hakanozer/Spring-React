package com.works.restcontrollers;

import com.works.entities.Admin;
import com.works.entities.Admins;
import com.works.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    final AdminService aService;
    public AdminRestController(AdminService aService) {
        this.aService = aService;
    }

    /*
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Admins admins) {

        for ( Admin item : admins.getAdmins() ) {
            System.out.println( item );
        }
        return null;
        //return aService.save( admin );
    }*/
    /*
    {
    "admins": [
            {
                "name": "Zehra",
                "email": "zehra@mail.com",
                "password": "12345",
                "roles": [
                    { "rid": 11 },
                    { "rid": 22 }
                ]
            },
            {
                "name": "Erdal",
                "email": "erdal@mail.com",
                "password": "12345",
                "roles": [
                    { "rid": 11 },
                    { "rid": 22 }
                ]
            }
        ]
    }
    */

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Admin admin) {
        return aService.save( admin );
    }

}
