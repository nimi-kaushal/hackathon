package com.evil.inc.employeelocator.service;

import com.evil.inc.employeelocator.dto.StoreDto;
import com.evil.inc.employeelocator.web.form.CreateStoreForm;

import java.util.Collection;

public interface StoreService {
  void create(CreateStoreForm form);

  Collection<StoreDto> getAll();

  Collection<StoreDto> getByDrugName(String drugName);
}
