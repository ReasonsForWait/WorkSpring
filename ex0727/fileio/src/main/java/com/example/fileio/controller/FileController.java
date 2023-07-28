package com.example.fileio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @PostMapping("/upload1")
    public @ResponseBody String multipartFileUpload1(MultipartFile[] uploadFiles) throws IOException {
        for(MultipartFile uploadFile : uploadFiles){
            // 이름이 비어 있지 않으면 파일을 특정 경로에 저장
            if(!uploadFile.getOriginalFilename().isEmpty()){
                uploadFile.transferTo(new File("D:/workspring/data", uploadFile.getOriginalFilename()));
                System.out.println(uploadFile.getOriginalFilename()+" 저장 완료");
            }else{
                System.out.println("데이터가 존재하지 않습니다.");
            }
        }
        System.out.println("모든 데이터가 저장되었습니다.");
        return "file1 received";
    }
}
