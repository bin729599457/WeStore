package com.westore.test;


import com.westore.utils.RequestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UrlTest {

    @Test
    public void testURL(){
        String appid = "wxfd21b79973f49459";
        String code = "00383LJO1ipxW41eL0HO1C4EJO183LJk";
        String app_se = "094ca7963f55405b23af1dafd702e012";
        String url_tmpl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
        url_tmpl = url_tmpl.replace("APPID",appid);
        url_tmpl = url_tmpl.replace("SECRET",app_se);
        url_tmpl = url_tmpl.replace("JSCODE",code);
        System.out.print(url_tmpl);
        System.out.print(RequestUtils.httpRequest(url_tmpl));
    }

}
