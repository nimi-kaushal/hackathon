package com.nimi.hackathon.hope.service;

import com.nimi.hackathon.hope.dto.CreateStoreDTO;
import com.nimi.hackathon.hope.dto.StoreDto;

import java.util.Collection;

public interface StoreService {
  void create(CreateStoreDTO form);

  Collection<StoreDto> getAll();

  Collection<StoreDto> getByDrugName(String drugName);
}
