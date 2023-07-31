package com.example.fileio.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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

    @GetMapping("/download1")
    public void download1(HttpServletResponse response){
        try {
            // 임시로 가져오고자 하는 그림 파일을 지정
            String path = "D:/workspring/data/yj.jpg";

            // 파일 경로를 접근하기 위한 Path 설정
            Path file = Paths.get(path);
            // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
            response.setHeader("Content-Disposition", "attachment;filename="+file.getFileName());
            // 파일 전송준비를 위한 Channel 설정(읽기 전용)
            FileChannel fc = FileChannel.open(file, StandardOpenOption.READ);
            // 스트림을 통한 목적지로 가는 통로 설정
            OutputStream out = response.getOutputStream();
            WritableByteChannel outputChannel = Channels.newChannel(response.getOutputStream());
            // 데이터 전송
            fc.transferTo(0, fc.size(), outputChannel);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



