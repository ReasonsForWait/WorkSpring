package com.example.validation.controller;

import com.example.validation.dto.DataInDTO1;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/valid1")
@Validated
public class Validate1Controller {

    @PostMapping("/req1")
    public String request1(@Validated @RequestParam("text1") @Size(min = 3, max=10) String text1,
                           @Validated @RequestParam("text2") @Size(min = 1, max=5) String text2){
        System.out.println("text1 : "+text1);
        System.out.println("text2 : "+text2);
        return "redirect:/";
    }

    @GetMapping("/req2/{id}")
    public String request2(@Validated @PathVariable("id") @Size(max=4) String id){
        System.out.println("id : "+id);
        return "redirect:/";
    }

    @PostMapping("/req3")
    public String request3(@Validated DataInDTO1 dto, BindingResult bindingResult){
        System.out.println("text3 : "+dto.getText3());
        System.out.println("text4 : "+dto.getText4());

        System.out.println("BindingResult : "+bindingResult);

        // 유효성 검사에서 위험한 부분이 있는지 체크
        if(bindingResult.hasErrors()){
            // 유효성 위반 결과를 모두 출력
            for (ObjectError objErr:bindingResult.getAllErrors()) {
                System.out.println("메세지 : "+objErr.getDefaultMessage());
                System.out.println("code : "+objErr.getCode());
                System.out.println("object name : "+objErr.getObjectName());

                // 유효성 위반 코드
                System.out.println("<<<<<< code >>>>>>");
                String[] codes = objErr.getCodes();
                for (String c1: codes) {
                    System.out.println(c1);
                }

                // 유효성 위반에 대한 대응 메시지 처리
                if(codes[0].equals("Size.dataInDTO1.text3")){
                    System.out.println("text3는 1 ~ 5 글자 사이를 담을 수 있습니다");
                } else if (codes[0].equals("Size.dataInDTO1.text4")) {
                    System.out.println("text3는 3 ~ 10 글자 사이를 담을 수 있습니다");
                }
            }
        }

        return "redirect:/";
    }

    @PostMapping("/req4")
    @ResponseBody
    public ResponseEntity<String> request4(
            @Validated @RequestBody DataInDTO1 dto, BindingResult bindingResult){
        System.out.println("text3 : "+dto.getText3());
        System.out.println("text4 : "+dto.getText4());

        System.out.println("BindingResult : "+bindingResult);

        // 유효성 검사에서 위험한 부분이 있는지 체크
        if(bindingResult.hasErrors()){
            // 유효성 위반 결과를 모두 출력
            for (ObjectError objErr:bindingResult.getAllErrors()) {
                System.out.println("메세지 : "+objErr.getDefaultMessage());
                System.out.println("code : "+objErr.getCode());
                System.out.println("object name : "+objErr.getObjectName());

                // 유효성 위반 코드
                System.out.println("<<<<<< code >>>>>>");
                String[] codes = objErr.getCodes();
                for (String c1: codes) {
                    System.out.println(c1);
                }

                // 유효성 위반에 대한 대응 메시지 처리
                if(codes[0].equals("Size.dataInDTO1.text3")){
                    System.out.println("text3는 1 ~ 5 글자 사이를 담을 수 있습니다");
                } else if (codes[0].equals("Size.dataInDTO1.text4")) {
                    System.out.println("text3는 3 ~ 10 글자 사이를 담을 수 있습니다");
                }
            }
        }


        ResponseEntity<String> entity =
                new ResponseEntity<>("전송 성공", HttpStatus.OK);

        return entity;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public String exception1(ConstraintViolationException e1){
        System.out.println("해당 에러 발생");

        System.out.println(e1.getCause());
        System.out.println(e1.getMessage());
        return "/error1";
    }
}
