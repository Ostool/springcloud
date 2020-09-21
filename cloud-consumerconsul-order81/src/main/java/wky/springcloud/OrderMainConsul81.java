package wky.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainConsul81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainConsul81.class,args);
    }
}
