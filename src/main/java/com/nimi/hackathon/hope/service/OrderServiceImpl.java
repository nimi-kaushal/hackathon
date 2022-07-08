package com.nimi.hackathon.hope.service;

import com.nimi.hackathon.hope.domain.Drug;
import com.nimi.hackathon.hope.domain.Reservation;
import com.nimi.hackathon.hope.domain.Store;
import com.nimi.hackathon.hope.dto.OrderDTO;
import com.nimi.hackathon.hope.repo.OrderRepository;
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
    final Reservation reservation = Reservation.builder().createDate(LocalDateTime.now()).store(new Store()).drug(new Drug()).status(null).build();
    orderRepository.save(reservation);
  }


  @Transactional
  public Collection<Reservation> getAll() {
    return null;//orderRepository.findAll();

  }

}
