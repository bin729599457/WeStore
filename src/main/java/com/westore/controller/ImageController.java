package com.westore.controller;


import com.westore.model.AjaxJSON;
import com.westore.model.T_B_Comment;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping("/ImageController")
public class ImageController {


     @Value("${application.picpath}")
     private String picpath;


    @RequestMapping(value="/uploadImg.do" ,produces="application/json" ,method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object uploadImg(@RequestParam("file") CommonsMultipartFile[] files) {
        AjaxJSON res = new AjaxJSON();
        System.out.println(picpath);
        List<String> p_list = new ArrayList<String>();
        for (int i = 0; i < files.length; i++) {
            System.out.println("fileName---------->" + files[i].getOriginalFilename());
            try {
                String new_name = new Date().getTime() + files[i].getOriginalFilename();
                FileOutputStream os = new FileOutputStream(picpath + new_name);
                FileInputStream in = (FileInputStream) files[i].getInputStream();
                int b = 0;
                while((b=in.read()) != -1){
                    os.write(b);
                }
                os.flush();
                os.close();
                in.close();
                p_list.add(new_name);
                new_name=null;
            }catch (Exception e) {
                e.printStackTrace();
                res.setSuccess(false);
                res.setMsg("上传出错");
                return res;
            }
        }
        res.setObj(p_list);
        res.setMsg("上传成功");
        res.setTotal((long)p_list.size());
        return res;
    }
}
