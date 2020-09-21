package wky.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wky.springcloud.entities.CommonsResult;
import wky.springcloud.entities.Payment;
import wky.springcloud.service.PaymentService;

@RestController
public class FeignController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/feign/get/{id}")
    public CommonsResult<Payment> findPaymentById(@PathVariable("id")Long id){
        CommonsResult<Payment> paymentId = paymentService.getPaymentById(id);
        return paymentId;
    }
}
