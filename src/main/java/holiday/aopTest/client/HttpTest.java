package holiday.aopTest.client;

import java.io.InputStream;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @Author: xuwei.shen
 * @Date: 2016/10/21
 * @Time: 22:27 Copyright (c) 2016, sxwpower@outlook.com All Rights Reserved.
 */
public class HttpTest {

	public static void main(String[] args) throws Exception {
		HttpTest httpTest = new HttpTest();
		httpTest.post(null);
	}

	public String post(Map<String, Object> map) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://www.baidu.com/");
		HttpResponse httpResponse = httpClient.execute(httpGet);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);

        HttpEntity httpEntity = httpResponse.getEntity();
        if (null != httpEntity){
            System.out.println("ContentType=" + httpEntity.getContentType());
            System.out.println("ContentLength=" + httpEntity.getContentLength());
            System.out.println("ContentEncoding=" + httpEntity.getContentEncoding());
            InputStream inputStream = httpEntity.getContent();
            int l = 0;
            byte[] tmp = new byte[2048];
            while ((l = inputStream.read(tmp,0,tmp.length)) != -1) {
                System.out.println(new String(tmp));
            }
        }
		return StringUtils.EMPTY;
	}
}
