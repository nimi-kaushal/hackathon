package com.nimi.hackathon.hope.web.controller;

import com.nimi.hackathon.hope.domain.Store;
import com.nimi.hackathon.hope.domain.StoreType;
import com.nimi.hackathon.hope.dto.CreateStoreDTO;
import com.nimi.hackathon.hope.dto.StoreDto;
import com.nimi.hackathon.hope.service.OrderServiceImpl;
import com.nimi.hackathon.hope.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  private final OrderServiceImpl orderService;

  @GetMapping
  public ModelAndView viewAllUsers() {
    final Collection<StoreDto> stores = storeService.getAll();
    final ModelAndView modelAndView = new ModelAndView("stores");
    modelAndView.addObject("stores", stores);
    modelAndView.addObject("createStoreForm", new CreateStoreDTO());
    modelAndView.addObject("StoreTypes", StoreType.values());
    modelAndView.addObject("orders", orderService.getAll());
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


  @PostMapping("/create")
  public String create(final Model model) {
    return "createStore";
  }

  @GetMapping("/create")
  public String loadCreatePage(final Model model) {
    model.addAttribute("Store", Store.builder().build());
    return "createStore";
  }
}