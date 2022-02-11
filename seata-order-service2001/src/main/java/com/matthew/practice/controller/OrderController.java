package com.matthew.practice.controller;

import com.matthew.practice.domain.CommonResult;
import com.matthew.practice.domain.Order;
import com.matthew.practice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    //启动的时候端口呗占了
    //http://localhost:2006//order/create?userId=1&productId=1&count=10&money=100
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
