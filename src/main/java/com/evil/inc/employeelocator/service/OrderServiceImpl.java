package com.evil.inc.employeelocator.service;

import com.evil.inc.employeelocator.domain.Drug;
import com.evil.inc.employeelocator.domain.Order;
import com.evil.inc.employeelocator.domain.Store;
import com.evil.inc.employeelocator.dto.OrderDTO;
import com.evil.inc.employeelocator.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {
  private final OrderRepository orderRepository;


  @Transactional
  public void create(final OrderDTO orderDTO) {
    final Order order = Order.builder().createDate(LocalDateTime.now()).store(new Store()).drug(new Drug()).status(null).build();
    orderRepository.save(order);
  }


  @Transactional
  public Collection<Order> getAll() {
    final Collection<Order> orders = orderRepository.findAll();
    return orders;
  }

}
