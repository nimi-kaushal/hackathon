package com.nimi.hackathon.hope.web.controller;

import com.nimi.hackathon.hope.domain.Reservation;
import com.nimi.hackathon.hope.dto.OrderDTO;
import com.nimi.hackathon.hope.dto.StoreDto;
import com.nimi.hackathon.hope.service.OrderServiceImpl;
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
  public ModelAndView viewOrderPage() {
    final Collection<Reservation> reservations = new ArrayList<>();
    final ModelAndView modelAndView = new ModelAndView("orders");
    modelAndView.addObject("orders", reservations);
    return modelAndView;
  }

  @PostMapping("/reserve")
  @ResponseBody
  public ResponseEntity<Collection<StoreDto>> reserve(@RequestBody final Object obj) {
    orderService.create(OrderDTO.builder().build());
    return ResponseEntity.ok(null);
  }

  @GetMapping("/byPerson")
  @ResponseBody
  public ResponseEntity<Collection<Reservation>> viewAllOrders() {
    return ResponseEntity.ok(orderService.getAll());

  }
}