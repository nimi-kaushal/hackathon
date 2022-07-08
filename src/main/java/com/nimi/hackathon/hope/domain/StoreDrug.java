package com.nimi.hackathon.hope.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_drug")
public class StoreDrug extends AbstractEntity {

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "store_id")
  private Store store;

  @ManyToOne
  @MapsId("id")
  @JoinColumn(name = "drug_id")
  private Drug drug;
}