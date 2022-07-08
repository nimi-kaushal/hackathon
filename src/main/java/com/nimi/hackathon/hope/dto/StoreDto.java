package com.nimi.hackathon.hope.dto;

import com.nimi.hackathon.hope.domain.GeoLocation;
import com.nimi.hackathon.hope.domain.StoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class StoreDto extends BaseDto {
  private String name;
  private String address;
  private GeoLocation geoLocation;
  private StoreType type;

}