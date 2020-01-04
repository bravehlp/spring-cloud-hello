package com.hello.client.web;
/**
 * ━━━━━━神兽出没━━━━━━
 * 　　 ┏┓     ┏┓
 * 　　┏┛┻━━━━━┛┻┓
 * 　　┃　　　　　 ┃
 * 　　┃　　━　　　┃
 * 　　┃　┳┛　┗┳  ┃
 * 　　┃　　　　　 ┃
 * 　　┃　　┻　　　┃
 * 　　┃　　　　　 ┃
 * 　　┗━┓　　　┏━┛　Code is far away from bug with the animal protecting
 * 　　　 ┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　┣┓
 * 　　　　┃　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　 ┃┫┫ ┃┫┫
 * 　　　　 ┗┻┛ ┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: ConsumerController.java
 * @Package com.hello.client.web
 * @Description:
 * @author KunPeng
 * @version V1.0
 * @date 2019-12-31 15:12
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        String url = "http://HELLO-SERVICE/hello";
        return restTemplate.getForEntity(url, String.class).getBody();
    }

    /**
     * Description:
     * web调用的异常处理方法
     * @return
     * @author Alex
     * @date 2020/1/5 00:30
     */
    public String helloFallback(){
        return "error";
    }

}
