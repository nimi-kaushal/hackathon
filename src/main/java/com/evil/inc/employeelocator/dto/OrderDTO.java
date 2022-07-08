package com.evil.inc.employeelocator.dto;

import com.evil.inc.employeelocator.domain.AbstractEntity;
import com.evil.inc.employeelocator.domain.Drug;
import com.evil.inc.employeelocator.domain.Store;
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
