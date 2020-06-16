package com.learn.cotroller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");

        //使用fileupload组件完成组件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //解析request对象,获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历
        for (FileItem item : fileItems) {
            //进行判断,当前item对象是否是上传文件项
            if (item.isFormField()) {
                //普通表单项
            } else {
                //上传文件项
                //获取到上传文件的名称
                String filename = item.getName();
                //把文件名 设置成唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                //完成文件上传
                item.write(new File(path, filename));
                //删除临时文件
                item.delete();
            }
        }

        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传");

        //使用fileupload组件完成组件上传
        //上传的位置
        //E:\apache-tomcat-8.5.50\webapps\ROOT\uploads
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //上传文件项
        //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件名 设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path, filename));

        return "success";
    }


    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器 文件上传");

        //定义上传服务器的路径
        String path = "http://localhost:9090/file/uploads/";

        //上传文件项
        //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件名 设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        //完成文件上传 跨服务器上传
        //创建客户端
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource resource = client.resource(path + filename);
        //上传文件
        resource.put(upload.getBytes());

        //E:\code\SpringMVC003fileserver\target\SpringMVC003fileserver\uploads
        return "success";
    }
}
