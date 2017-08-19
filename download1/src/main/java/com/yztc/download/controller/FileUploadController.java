package com.yztc.download.controller;

import com.yztc.download.util.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.Iterator;

@Controller
public class FileUploadController {

    /**
     * 通过流的方式上传问价你
     * @RequestParam("file" 将name = file 控件得到的文件封装成CommonsMultipartFile 对象
     * @return
     */
    @RequestMapping(value = "/upload.do",method = RequestMethod.POST)
    public  String provideUploadInfo(@RequestParam(value = "file")CommonsMultipartFile file) throws IOException{
        //用来检测程序运行时间
        long starTime = System.currentTimeMillis();
        System.out.println("fileName:"+file.getOriginalFilename());

        try{
            //获取输出流
            OutputStream outputStream = new FileOutputStream("D:/"+new Date().getTime()+file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream inputStream= file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while ((temp=inputStream.read())!=(-1)){
                outputStream.write(temp);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        long endTime =System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-starTime)+"ms");
        return "/success";
    }

    @RequestMapping(value = "/upload2.do",method = RequestMethod.POST)
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException{
      long startTime = System.currentTimeMillis();
        System.out.println("fileName:"+file.getOriginalFilename());
        String path = "D:/"+new Date().getTime()+file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);

        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/success";
    }

    /**
     * 用Spring提供的上传文件的方法
     * @return
     */
    @RequestMapping(value = "/upload3.do",method = RequestMethod.POST)
    public String SpringfileUpload(HttpServletRequest request ) throws Exception{

        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给 CommonsMultipatResolver(多部分解析器)
        UploadUtil.fileUpload(request,new String("D:/springUpload"));
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");

        return "/success";
    }
}
