package com.cpt202.demo.controller;

import com.cpt202.demo.entity.TypeInfo;
import com.cpt202.demo.service.TypeInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

 

@RestController
@RequestMapping(value = "/typeInfo")
public class TypeInfoController {
    @Resource
    private TypeInfoService typeInfoService;

    @PostMapping(value = "/add")
    public String add(TypeInfo typeInfo) {
        typeInfoService.add(typeInfo);
        return "200";
    }
}