package com.yztc.download.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class FileDownloadController {
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download ()throws IOException{

        String path ="D:\\springUploadwhile循环复制.wmv";
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        //为了解决中文名称乱码
        //设置文件名以及文件后缀名
        String fileName = new String("springUploadwhile循环复制.wmv".getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
