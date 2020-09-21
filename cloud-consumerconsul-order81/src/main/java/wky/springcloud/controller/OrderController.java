package wky.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private final static String PROVIDER_PAYMENT_CONSUL = "http://cloud-providerconsul-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul/order")
    public String OrderPaymentConsul(){
        String s = restTemplate.getForObject(PROVIDER_PAYMENT_CONSUL + "/consul/get", String.class);
        return s;
    }
}
