package com.example.thymeleaf.controller;

import com.example.thymeleaf.beans.UserDTO1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


// Rest 방식의 통신

/*      모든 백엔드에서는 Rest API의 지원은 다음과 같은 내용이 존재한다.
        무엇을 보낼 것인가 : 파라미터 지원
        어떤 형식으로 받을 것인가 : 메서드 지원
        어떤 데이터를 보낼 것인가 : 리턴 데이터 지원
        스프링에서는 위의 지원을 아래의 어노테이션 및 객체로 지원한다

        - 무엇을 보낼 것인가 : @RequestBody or @RequestParam or @PathVariable or @ModelAttribute 객체
        - 어떤 형식으로 보낼 것인가 : @GetMapping or @PostMapping or @PutMapping or @PatchMapping or @DeleteMapping
        - 어떤 데이터를 보낼 것인가 : @ResponseBody & ResponseEntity
        - 모든 백엔드가 각기 다른 형식으로 위의 스펙들을 지원한다. 즉 매커니즘을 이해하면 다른 백엔드의 스펙에 입문하기 쉬움

// Rest URL 스펙

        - 프론트 엔드와 백엔드와의 개발 프로세스를 진행하기 위해서는 반드시 둘 사이에서 Rest API를 지원하는 URL의 스펙을 공유해야 한다.

        이 스펙에서는 아래와 같은 형식들을 지원한다.

        -> 어떤 기능을 하는  요소를 넣을 것인가?
        -> 요청을 어떻게 보낼 것인가?
        -> 응답을 어떻게 보낼 것인가?

        - 이와 같은 형식을 서로 공유하기 위해서 반드시 둘 사이에 정의된 스펙을 공유해야 하며 이 스펙을 "프로토콜 정의서" 라고 부른다. */
@RestController
@RequestMapping("/rest2")
public class Rest2Controller {
    @GetMapping("/users1")
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

    @GetMapping("/users11")
    public ResponseEntity<List<UserDTO1>> test11(@RequestParam String name, @RequestParam int age){
        System.out.println("name : " + name);
        System.out.println("age : " + age);

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
    public ResponseEntity<String> test3(@RequestBody UserDTO1 dto){
        System.out.println(dto);

        return new ResponseEntity<>("ㅇㅇ", HttpStatus.OK);
    }

    @PatchMapping("/users4")
    @ResponseBody
    public List<UserDTO1> test4(@RequestBody UserDTO1 dto){
        System.out.println(dto);

        UserDTO1 bean1 = new UserDTO1("aa",123,11.22,false);
        UserDTO1 bean2 = new UserDTO1("bb",1234,22.22,false);
        UserDTO1 bean3 = new UserDTO1("cc",12345,33.22,true);

        List<UserDTO1> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        return list;
    }

    @DeleteMapping("/users5")
    public List<UserDTO1> test5(@RequestBody List<UserDTO1> res){
        for (UserDTO1 dto : res) {
            System.out.println(dto);
        }

        UserDTO1 bean1 = new UserDTO1("aa",123,11.22,false);
        UserDTO1 bean2 = new UserDTO1("bb",1234,22.22,false);
        UserDTO1 bean3 = new UserDTO1("cc",12345,33.22,true);

        List<UserDTO1> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        return list;
    }
}
