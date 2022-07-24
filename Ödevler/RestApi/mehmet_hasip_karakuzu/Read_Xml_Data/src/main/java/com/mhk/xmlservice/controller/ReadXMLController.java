package com.mhk.xmlservice.controller;


import com.mhk.xmlservice.service.ReadXMLService;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadXMLController {

  private final ReadXMLService readXMLService;

  public ReadXMLController(ReadXMLService readXMLService) {
    this.readXMLService = readXMLService;
  }

  @GetMapping("xml")
  ResponseEntity getXML() {
    Map<String, Object> hm = new LinkedHashMap<>();
    hm.put("result", readXMLService.Currencies());
    return new ResponseEntity<>(hm, HttpStatus.OK);
  }

  @GetMapping("xml/{currencyCode}")
  ResponseEntity getXML(@PathVariable String currencyCode) {
    Map<String, Object> hm = new LinkedHashMap<>();
    hm.put("result", readXMLService.getCurrencyByCurrencyCode(currencyCode));
    return new ResponseEntity<>(hm, HttpStatus.OK);
  }
}
