package wky.spirngcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import wky.springcloud.entities.CommonsResult;
import wky.springcloud.entities.Payment;

@RestController
public class OrderController {
    //private final static String PAYMENT_URL="http://localhost:8001/";
    private final static String PAYMENT_URL="http://CLOUD-PROVIDER-PAYMENT/";
    @Value("${server.port}")
    private String port;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonsResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonsResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonsResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"payment/get/"+id,CommonsResult.class);
    }
}
