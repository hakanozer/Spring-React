package com.works.restcontrollers;

import com.works.entities.User;
import com.works.utils.ERest;
import com.works.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    List<User> ls = new ArrayList<>();
    Result rs = new Result();
    public UserRestController () {
        ls = rs.users();
    }

    // http://localhost/user/list
    // @GetMapping -> get yöntemi ile servisi çalıştır

    // ? ile veri gönderimi
    // Query String -> @RequestParam ifadesi ile bu değer alınır.
    // defaultValue = "" -> değişken değeri gelmediğinde default değer oluşturma yeteneğine sahiptir.
    // @RequestParam(defaultValue = "") String name

    // path ile değer gönderme
    // http://localhost/user/list/value
    // @PathVariable String data
    @GetMapping("/search/{data}")
    public Map list(@PathVariable String data) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        System.out.println( "Pull Data : " + data );
        hm.put(ERest.status, true);
        hm.put(ERest.message, "Success");
        hm.put(ERest.result, rs.search(data, ls) );
        return hm;
    }

    // all user list
    @GetMapping("/list")
    public Map listx() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.message, "Success");
        hm.put(ERest.result, ls );
        return hm;
    }

    /*
    @PostMapping("/user/save")
    public Map save(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email
    ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        User u = new User(id, name, surname, email);
        ls.add(u);
        hm.put(ERest.status, true);
        hm.put(ERest.message, "Success");
        hm.put(ERest.result, ls );
        return hm;
    }
    */

    @PostMapping("/save")
    public Map save( @RequestBody User u ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        ls.add(u);
        hm.put(ERest.status, true);
        hm.put(ERest.message, "Success");
        hm.put(ERest.result, ls );
        return hm;
    }

    // delete action
    @DeleteMapping("/delete/{index}")
    public Map delete( @PathVariable int index ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            ls.remove(index);
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Delete Success");
        }catch (Exception ex) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Delete Fail");
        }
        return hm;
    }


}