package wky.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/client/config")
    public String configInfo(){
        return configInfo;
    }
}
