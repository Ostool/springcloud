package wky.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/consul/get")
    public String paymentConsul(){
        return "cloud application port :"+port+"\t"+ UUID.randomUUID().toString();
    }
}
