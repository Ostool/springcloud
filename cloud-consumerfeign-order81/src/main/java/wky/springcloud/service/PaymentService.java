package wky.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wky.springcloud.entities.CommonsResult;
import wky.springcloud.entities.Payment;

@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentService {
    @GetMapping(value = "/payment/get/{id}")
    CommonsResult<Payment> getPaymentById(@PathVariable("id") Long id);


}
