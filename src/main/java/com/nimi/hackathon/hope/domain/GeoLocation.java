package com.nimi.hackathon.hope.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation {

  private Double latitude;
  private Double longitude;

}
