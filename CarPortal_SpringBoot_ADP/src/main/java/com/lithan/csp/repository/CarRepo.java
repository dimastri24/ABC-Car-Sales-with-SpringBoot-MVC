package com.lithan.csp.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.csp.entity.Cars;
import com.lithan.csp.entity.Users;

@Repository
public interface CarRepo extends JpaRepository<Cars, Long>{
	
	@Query(value = "SELECT c FROM Cars c WHERE c.makeYear LIKE '%' || :keyword || '%'"
			+ "OR c.model LIKE '%' || :keyword || '%'"
			+ "OR c.brand LIKE '%' || :keyword || '%'")
	public List<Cars> searchByParam(@Param("keyword") String keyword);
	
	public List<Cars> findByAmountBetween(BigDecimal startPrice, BigDecimal endPrice);
	
	@Query(value = "SELECT c FROM Cars c WHERE c.user IN :userid")
	public List<Cars> findByUser(@Param("userid") Users user);
}
