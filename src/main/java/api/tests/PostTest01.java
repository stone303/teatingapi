package api.tests;

import api.base.TestBase;
import api.data.userData;
import api.restClient.RestClient;
import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class PostTest01 {

    TestBase testBase;
    RestClient restClient;
    String host;
    String url;
    CloseableHttpResponse response;

    @BeforeClass
    public void setUp(){
        testBase = new TestBase();
        host = testBase.pro.getProperty("HOST");//读取config.properties里面的根url
        url = host + "/api/users"; //进入https://reqres.in/ 网站下拉 有Get/Post/Put方法测试的说明文档
    }
    @Test
    public void postCreate() throws IOException {
        restClient = new RestClient();
        //准备请求头信息
        HashMap<String,String> headermap = new HashMap<String, String>();
        headermap.put("Content-Type","application/json");

        //实例化数据对象 并将其转换成json格式
        userData userData = new userData("morpheus","leader");
        String dataJsonString = JSON.toJSONString(userData);
        //post请求
        response = restClient.postApi(url,dataJsonString,headermap);
        //得到响应结果 并输出
        String responseString = EntityUtils.toString(response.getEntity());
        System.out.println("response---->" + responseString);
    }

}
