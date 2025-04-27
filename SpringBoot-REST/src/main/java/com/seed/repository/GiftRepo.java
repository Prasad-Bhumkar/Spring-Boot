package com.seed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seed.entity.Gift;

@Repository
public interface GiftRepo extends JpaRepository<Gift, Integer>{

	@Query("select g.giftName from Gift g")
	List<String> findAllGiftNames();
	
	@Query("from Gift g where g.category = :category")
	List<Gift> findByCategory(String category);

	@Query("from Gift g where g.price between :min and :max")
	List<Gift> findByPriceRange(double min, double max);

	
	
}
