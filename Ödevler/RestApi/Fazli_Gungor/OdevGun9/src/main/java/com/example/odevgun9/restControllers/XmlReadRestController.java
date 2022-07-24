package com.example.odevgun9.restControllers;

import com.example.odevgun9.services.XmlReadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class XmlReadRestController {

    final XmlReadService xmlService;
    public XmlReadRestController(XmlReadService xmlService) {
        this.xmlService = xmlService;
    }

    @GetMapping("/currency")
    public ResponseEntity currency() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("result", xmlService.AllCurrency());
        return new ResponseEntity( hm, HttpStatus.OK );
    }
    @GetMapping("/currency/{money}")
    public ResponseEntity money(@PathVariable String money) {
        return xmlService.singleCurrency(money);
    }

}
