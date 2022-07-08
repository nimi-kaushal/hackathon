package com.evil.inc.employeelocator.web.controller;

import com.evil.inc.employeelocator.domain.StoreType;
import com.evil.inc.employeelocator.dto.StoreDto;
import com.evil.inc.employeelocator.service.StoreService;
import com.evil.inc.employeelocator.web.form.CreateStoreForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

  private final StoreService storeService;

  @GetMapping
  public ModelAndView viewAllUsers() {
    final Collection<StoreDto> stores = storeService.getAll();
    final ModelAndView modelAndView = new ModelAndView("stores");
    modelAndView.addObject("stores", stores);
    modelAndView.addObject("createStoreForm", new CreateStoreForm());
    modelAndView.addObject("StoreTypes", StoreType.values());
    return modelAndView;
  }


  @GetMapping("/all")
  @ResponseBody
  public ResponseEntity<Collection<StoreDto>> getAllStores() {
    final Collection<StoreDto> stores = storeService.getAll();
    return ResponseEntity.ok(stores);
  }

  @GetMapping("/search")
  @ResponseBody
  public ResponseEntity<Collection<StoreDto>> searchStores(@RequestParam("drugName") final Optional<String> drugName) {
    Collection<StoreDto> stores = Collections.EMPTY_LIST;

    if (drugName.isPresent()) {
      stores = storeService.getByDrugName(drugName.get());
    }
    return ResponseEntity.ok(stores);
  }
}