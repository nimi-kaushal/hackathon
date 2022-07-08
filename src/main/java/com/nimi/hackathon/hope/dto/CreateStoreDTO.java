package com.nimi.hackathon.hope.dto;

import com.nimi.hackathon.hope.domain.StoreType;
import lombok.Data;

@Data
public class CreateStoreDTO {
  private String name;
  private String street;
  private String city;
  private String country;
  private StoreType type;

}
