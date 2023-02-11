package com.gamjaring.web.springboot.httpconnection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpConn {

    public static String httpConnPost(String url, String message) {
        String sb="";

        try{
            HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();

            //불러오는데 시간이 오래 걸리는 경우 Time out 설정
            conn.setReadTimeout(10000);
            //연결하는데 시간이 오래 걸리는 경우 Time out 설정
            conn.setConnectTimeout(15000);
            //연결 방법 설정
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Accept-Charset 설정 UTF-8 or ASCII
            conn.setRequestProperty("Accept-Charset", "UTF-8");
//            conn.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;charset=UTF-8");

            // POST로 넘겨줄 파라미터 생성.
            byte[] outputInBytes = message.getBytes(StandardCharsets.UTF_8);
            OutputStream os = conn.getOutputStream();
            os.write(outputInBytes);
            os.close();

            //결과값을 받아온다.
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = br.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            br.close();

            if(sb.contains("ok")){
                return "api-axios complete";
                //return resultsService.getSelectPhotoListUrl(member);
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        //return resultsService.getSelectPhotoListUrl(member); // S3에 사진 18개를 모두 가지고 있어야 함
        return "errorPage/500";
    }
}