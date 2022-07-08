package com.evil.inc.employeelocator.repo;

import com.evil.inc.employeelocator.domain.Order;
import com.evil.inc.employeelocator.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  @Query("SELECT s FROM Store s join s.drugs d WHERE d.drug.name = 'avx'")
  Collection<Store> getByDrugName(@Param("name") String name);
}
