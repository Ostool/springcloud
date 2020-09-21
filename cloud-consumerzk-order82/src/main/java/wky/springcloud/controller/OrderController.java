package wky.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private final static String ZK_URL = "http://cloud-provider-payment/";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/zk/payment")
    public String fun1(){
        String s = restTemplate.getForObject(ZK_URL + "zk/get", String.class);
        return s;

    }
}
