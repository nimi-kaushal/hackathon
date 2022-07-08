package com.evil.inc.employeelocator.web.controller;

import com.evil.inc.employeelocator.domain.Order;
import com.evil.inc.employeelocator.dto.OrderDTO;
import com.evil.inc.employeelocator.dto.StoreDto;
import com.evil.inc.employeelocator.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderServiceImpl orderService;

  @GetMapping
  public ModelAndView viewAllOrders() {
    final Collection<Order> orders = new ArrayList<>();
    final ModelAndView modelAndView = new ModelAndView("orders");
    modelAndView.addObject("orders", orders);
    return modelAndView;
  }

  @PostMapping("/reserve")
  @ResponseBody
  public ResponseEntity<Collection<StoreDto>> reserve(@RequestBody final Object obj) {
    orderService.create(OrderDTO.builder().build());
    return ResponseEntity.ok(null);
  }

}