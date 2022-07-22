package com.example.xmlreadodev.controllers;

import com.example.xmlreadodev.services.XmlReadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchangerate")
public class XmlReadRestController {
    final XmlReadService xmlReadService;

    public XmlReadRestController(XmlReadService xmlReadService) {
        this.xmlReadService = xmlReadService;
    }

    @GetMapping("/allexchangerates")
    public ResponseEntity getAllCurrency() {
        return xmlReadService.allExchangeRate();
    }

    @GetMapping("/{exchangerate}")
    public ResponseEntity getAllCurrency(@RequestParam(defaultValue = " ") String exchangerate) {
        return xmlReadService.getExchangeRate(exchangerate);
    }
}
