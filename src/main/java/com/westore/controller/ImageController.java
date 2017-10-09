package com.westore.controller;


import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Comment;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/ImageController")
public class ImageController {


     @Value("${application.picpath}")
     private String picpath;


    @RequestMapping(value="/uploadImg.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object uploadImg(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        AjaxJSON aj = new AjaxJSON();
        List<String> p_list = new ArrayList<String>();
        try {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    int time = (int) System.currentTimeMillis();
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if (file != null) {
                        String myFileName = file.getOriginalFilename();
                        if (myFileName.trim() != "") {
                            //重命名上传后的文件名
                            String fileName = String.valueOf(time) + file.getOriginalFilename();
                            //定义上传路径
                            String path = picpath + fileName;
                            File localFile = new File(path);
                            file.transferTo(localFile);
                            p_list.add(fileName);
                        }
                    }
                }
            }
            aj.setObj(p_list);
            aj.setSuccess(true);
            aj.setTotal((long)p_list.size());
        }catch (Exception e){
            aj.setMsg(e.getMessage());
            aj.setSuccess(false);
            return aj;
        }
        return aj;
    }
}
