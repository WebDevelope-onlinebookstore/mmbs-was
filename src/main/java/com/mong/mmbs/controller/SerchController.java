package com.mong.mmbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.SearchDto;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.service.SerchService;


@RequestMapping("/api")
@RestController
public class SerchController {
    @Autowired SerchService serchService;

    @PostMapping("/serch")
    public ResponseDto<?> search(@RequestBody SearchDto requsetBody) {
        ResponseDto<?> result = serchService.search(requsetBody);
        return result;
    }
    
}
