package com.evil.inc.employeelocator.web.form;

import com.evil.inc.employeelocator.domain.StoreType;
import lombok.Data;

@Data
public class CreateStoreForm {
  private String name;
  private String street;
  private String city;
  private String country;
  private StoreType type;

}
