package com.nimi.hackathon.hope.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store")
public class Store extends AbstractEntity {
  private String name;

  @Embedded
  private Address address;

  private String phone;

  @Embedded
  private GeoLocation geoLocation;

  @Enumerated(EnumType.STRING)
  private StoreType type;

  @OneToMany(mappedBy = "drug")
  private Collection<StoreDrug> drugs;
}