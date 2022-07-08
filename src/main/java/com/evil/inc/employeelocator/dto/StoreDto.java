package com.evil.inc.employeelocator.dto;

import com.evil.inc.employeelocator.domain.GeoLocation;
import com.evil.inc.employeelocator.domain.StoreType;
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