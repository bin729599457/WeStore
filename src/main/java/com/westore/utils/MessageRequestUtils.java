package com.westore.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageRequestUtils {


    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";
    private static final String SEND_SERVER_URL="https://api.netease.im/sms/sendcode.action";
    private static final String APP_KEY="aae62be55423d66414caac4583ace316";
    private static final String APP_SECRET="e172de10d31b";
    private static final String CHECK_SERVER_URL = "https://api.netease.im/sms/verifycode.action";
    private static final String NONCE = "123123";

    public static String SendRequest(String nbr){
        String result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        try{
            //设置请求参数(用户手机号)
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("mobile", nbr));
            formparams.add(new BasicNameValuePair("codeLen", String.valueOf(6)));
            HttpEntity reqEntity = new UrlEncodedFormEntity(formparams, "utf-8");

            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(8000).setConnectTimeout(8000)
                    .setConnectionRequestTimeout(8000).build();

            String curTime=String.valueOf((new Date().getTime()/1000L));
            String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);


            //装配请求并发送(填充headers)
            HttpPost post = new HttpPost(SEND_SERVER_URL);
            post.addHeader("AppKey",APP_KEY);
            post.addHeader("Nonce",NONCE);
            post.addHeader("CurTime",curTime);
            post.addHeader("CheckSum",checkSum);
            post.addHeader("Content-Type",CONTENT_TYPE);
            post.setEntity(reqEntity);
            post.setConfig(requestConfig);
            HttpResponse response = client.execute(post);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity resEntity = response.getEntity();
                result = EntityUtils.toString(resEntity, "utf-8");

            } else {
                System.out.println("请求失败");
            }
        }
        catch(ClientProtocolException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            // 关闭连接,释放资源
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }



}
