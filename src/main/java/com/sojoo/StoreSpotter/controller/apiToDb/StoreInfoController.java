package com.sojoo.StoreSpotter.controller.apiToDb;

import com.sojoo.StoreSpotter.service.apiToDb.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class StoreInfoController {
    private final StoreInfoService storeInfoService;

    @Autowired
    public StoreInfoController(StoreInfoService storeInfoService) {
        this.storeInfoService = storeInfoService;
    }

    @GetMapping("/saveStoreInfo")
    public ResponseEntity<String> fetchData() throws Exception {
        System.out.println("saveStoreInfo 동작");
        storeInfoService.fetchDataFromPublicAPI();
        return ResponseEntity.ok("Data fetched successfully!");
    }

}


