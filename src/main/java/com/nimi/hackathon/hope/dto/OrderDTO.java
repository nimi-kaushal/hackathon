package com.nimi.hackathon.hope.dto;

import com.nimi.hackathon.hope.domain.AbstractEntity;
import com.nimi.hackathon.hope.domain.Drug;
import com.nimi.hackathon.hope.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends AbstractEntity {

  private Store store;
  private Drug drug;
  private String status;
  public LocalDateTime createDate;
}
