package com.example.thymeleaf.controller;

import com.example.thymeleaf.beans.UserDTO1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/rest1")
public class Rest1Controller {
    @GetMapping("/page1")
    public String rest1(){
        return "rest1/page1";
    }

    @GetMapping("/page2")
    public String rest2(){
        return "rest1/page2";
    }

    // Rest 방식 Example1
    // @ResponseBody : 페이지를 호출하는 것이 아니라 데이터만 호출할 경우 사용하는 어노테이션
    @GetMapping("/users1")
    @ResponseBody
    public ResponseEntity<List<UserDTO1>> test1(){
        UserDTO1 bean1 = new UserDTO1("aa",123,11.22,false);
        UserDTO1 bean2 = new UserDTO1("bb",1234,22.22,false);
        UserDTO1 bean3 = new UserDTO1("cc",12345,33.22,true);

        List<UserDTO1> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        ResponseEntity<List<UserDTO1>> entry = new ResponseEntity<>(list, HttpStatus.OK);
        return entry;
    }

    // @RequestBody : 비동기 데이터를 전송 받는 객체를 위해 사용하는 어노테이션
    @PostMapping("/users2")
    @ResponseBody
    public ResponseEntity<String> test2(@RequestBody Map<String, Object> map){
        Iterator it =  map.entrySet().iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        return new ResponseEntity<>("ㅇㅇ", HttpStatus.OK);
    }

    @PutMapping("/users3")
    @ResponseBody
    public ResponseEntity<Map<String, String>> test3(@RequestBody Map<String, Object> map){
        Iterator it =map.entrySet().iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        Map<String, String> result = new HashMap<>();
        result.put("str1", "aaa1");
        result.put("str2", "aaa2");
        result.put("str3", "aaa3");

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/users4")
    @ResponseBody
    public ResponseEntity<List<Map<String, String>>> test4(@RequestBody Map<String, Object> map){
        Iterator it =map.entrySet().iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        Map<String, String> result1 = new HashMap<>();
        result1.put("str1", "m1aaa1");
        result1.put("str2", "m1aaa2");
        result1.put("str3", "m1aaa3");

        Map<String, String> result2 = new HashMap<>();
        result2.put("str1", "m2aaa1");
        result2.put("str2", "m2aaa2");
        result2.put("str3", "m2aaa3");

        Map<String, String> result3 = new HashMap<>();
        result3.put("str1", "m3aaa1");
        result3.put("str2", "m3aaa2");
        result3.put("str3", "m3aaa3");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(result1);
        list.add(result2);
        list.add(result3);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("/users5")
    @ResponseBody
    public ResponseEntity<List<Map<String, String>>> test5(@RequestBody List<Map<String, Object>> req){

        for (Map<String, Object> map : req){
            System.out.println(map);
        }

        Map<String, String> result1 = new HashMap<>();
        result1.put("str1", "m1aaa1");
        result1.put("str2", "m1aaa2");
        result1.put("str3", "m1aaa3");

        Map<String, String> result2 = new HashMap<>();
        result2.put("str1", "m2aaa1");
        result2.put("str2", "m2aaa2");
        result2.put("str3", "m2aaa3");

        Map<String, String> result3 = new HashMap<>();
        result3.put("str1", "m3aaa1");
        result3.put("str2", "m3aaa2");
        result3.put("str3", "m3aaa3");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(result1);
        list.add(result2);
        list.add(result3);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
