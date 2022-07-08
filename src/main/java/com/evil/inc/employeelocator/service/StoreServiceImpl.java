package com.evil.inc.employeelocator.service;

import com.evil.inc.employeelocator.domain.Store;
import com.evil.inc.employeelocator.dto.StoreDto;
import com.evil.inc.employeelocator.repo.StoreRepository;
import com.evil.inc.employeelocator.web.form.CreateStoreForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class StoreServiceImpl implements StoreService {
  private final StoreRepository storeRepository;
  private final GeoLocationService geoLocationService;

  @Transactional
  public void create(final CreateStoreForm form) {
    final Store store = Store.builder().name(form.getName()).build();
    storeRepository.save(store);
  }

  @Override
  @Transactional
  public Collection<StoreDto> getAll() {
    final Collection<Store> stores = storeRepository.findAll();

    return stores.stream()
      .map(store -> new StoreDto(store.getName(), store.getAddress().toString(), store.getGeoLocation(), store.getType()))
      .collect(Collectors.toList());

  }

  public Collection<StoreDto> getByDrugName(final String drugName) {
    final Collection<Store> stores = storeRepository.findAll();

    return stores.stream()
      .map(store -> StoreDto.builder().id(store.getId()).name(store.getName()).address(store.getAddress().toString()).geoLocation(store.getGeoLocation()).type(
        store.getType()).build())
      .collect(Collectors.toList());

  }

}
