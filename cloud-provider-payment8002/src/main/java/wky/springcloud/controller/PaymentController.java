package wky.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import wky.springcloud.entities.CommonsResult;
import wky.springcloud.entities.Payment;
import wky.springcloud.service.PaymentService;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping("/payment/create")
    public CommonsResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result>0){
            return new CommonsResult(200,"插入数据库成功,端口号："+port,result);
        }else {
            return new CommonsResult(444,"插入数据库失败",null);

        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonsResult findPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return new CommonsResult(200,"查询结果成功,端口号："+port,payment);
        }else {
            return new CommonsResult(444,"查询失败，查询ID："+id,null);
        }
    }

    @GetMapping("/payment/service")
    public Object getService(){
        List<String> services = discoveryClient.getServices();
        for (String service: services) {
            log.info("#########"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance:instances) {
            log.info("######"+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getUri()+"\t"+instance.getServiceId());
        }
        return this.discoveryClient;

    }
}
