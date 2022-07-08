package com.nimi.hackathon.hope.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation extends AbstractEntity {

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "store_id", referencedColumnName = "id")
  private Store store;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "drug_id", referencedColumnName = "id")
  private Drug drug;

  private String status;
  public LocalDateTime createDate;
}
