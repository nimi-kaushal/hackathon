package com.nimi.hackathon.hope.service;


import com.nimi.hackathon.hope.domain.GeoLocation;

import java.util.Optional;

public interface GeoLocationService {
  Optional<GeoLocation> computeGeoLocation(String fullAddressLine);
}
