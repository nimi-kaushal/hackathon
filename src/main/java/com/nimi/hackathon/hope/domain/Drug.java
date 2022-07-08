package com.nimi.hackathon.hope.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Drug extends AbstractEntity {
  private String name;
  private double price;
  private int quantity;

  @OneToMany(mappedBy = "store")
  private List<StoreDrug> stores;
}
