package com.lh.cloud.rhystrix.controller;

import com.lh.cloud.rhystrix.service.DcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dc")
@RestController
public class DcController {
    @Autowired
    private DcService dcService;

    @GetMapping("/getDc")
    public String getDc() {
        return dcService.getDc();
    }
}
