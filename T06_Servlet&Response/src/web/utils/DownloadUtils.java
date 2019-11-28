package web.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author kwin
 * @create 2019-11-26 23:05
 */
public class DownloadUtils {

    public static String getFileName(String agent,String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")){
            //IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename.replace("+"," ");
        }else if (agent.contains("Firefox")){
            //火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        }else{
            //其他浏览器
            filename = URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }
}
