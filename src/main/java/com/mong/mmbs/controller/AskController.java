package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.AskDto;
import com.mong.mmbs.dto.AskUpdateDto;
import com.mong.mmbs.dto.AskDeleteDto;
import com.mong.mmbs.service.AskService;

@RestController
@RequestMapping("/api/ask")
public class AskController {

  @Autowired AskService askService;

  @GetMapping("/askList")
  public ResponseDto<?> getAskList(@AuthenticationPrincipal String userId) { 
		return askService.getAskList(userId);
	}

  @PostMapping("/askWrite")
  public ResponseDto<?> askWrite(@RequestBody AskDto requestBody) {
    ResponseDto<?> result = askService.askWrite(requestBody);
    return result;
  }

  @GetMapping("/userAskUpdate/{askId}")
  public ResponseDto<?> askUpdateList(@PathVariable("askId") int askId) {
    return askService.askUpdateList(askId);
  }
  
  @PostMapping("/userAskUpdate/save")
  public ResponseDto<?> askUpdate(@RequestBody AskUpdateDto requestBody) {
    ResponseDto<?> result = askService.askUpdate(requestBody);
    return result;
  }

  @PostMapping("/userDelete")
  public ResponseDto<?> askDelete(@RequestBody AskDeleteDto requestBody){
    ResponseDto<?> result = askService.askDelete(requestBody);
    return result;
  }
}