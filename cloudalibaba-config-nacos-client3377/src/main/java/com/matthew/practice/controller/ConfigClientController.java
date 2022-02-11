package com.matthew.practice.controller;

import com.matthew.practice.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope //支持Nacos的动态刷新功能。
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;


    @Resource
    private IMessageProvider messageProvider;


    //生产消息
    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }


    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
