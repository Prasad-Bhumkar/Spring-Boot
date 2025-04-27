package com.seed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable; // Import PathVariable
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam; // Import RequestParam
import org.springframework.web.bind.annotation.RestController;

import com.seed.entity.Gift;
import com.seed.repository.GiftRepo;

@RestController
public class GiftController {

	@Autowired
	GiftRepo repo;
	
	@GetMapping("/getallgifts")
	public List<Gift> getAllGifts(){
		System.out.println("controller........find all gifts");
		List<Gift> IsGift = repo.findAll();
		return IsGift;
		
	}
	
	@GetMapping("/getgiftnames")
	public List<String> getGiftNames(){
		System.out.println("controller........find all gift names");
		List<String> gNames = repo.findAllGiftNames();
		return gNames;
		
	}

	@GetMapping("/getgiftbycategory/{category}")
    public List<Gift> getGiftByCategory(@PathVariable String category){
        System.out.println("controller........find gift by category: " + category);
        List<Gift> gCategory = repo.findByCategory(category);
        System.out.println("Retrieved gifts by category: " + gCategory); // Log the retrieved gifts
        return gCategory;
		
	}

	@GetMapping("/getgiftbypricerange")
	public List<Gift> getGiftByPriceRange(@RequestParam double min, @RequestParam double max){
		System.out.println("controller........find gift by price range: min=" + min + ", max=" + max);
		List<Gift> gPrice = repo.findByPriceRange(min, max);
		System.out.println("Retrieved gifts by price range: " + gPrice); // Log the retrieved gifts
		return gPrice;
		
	}
	
	@PostMapping("/addgift")
	public void addGift(@RequestBody Gift g) {
		System.out.println("controller............ add gift");
		repo.save(g);
	}

	@DeleteMapping("/deletegiftbyid/{id}")
	public ResponseEntity<String> deleteGift(@PathVariable int id){
		if (repo.existsById(id)){
			repo.deleteById(id);
			return ResponseEntity.ok("Gift with id " + id + " deleted successfully");
		}
		else{
			return ResponseEntity.ok("Gift with id " + id + " not found");
		}
		
	}
	
	@PutMapping("/updategift/{id}")
	public Gift updatePGift(@RequestBody Gift g, @PathVariable int id){
		return repo.findById(id)
				.map(gift -> {
					gift.setGiftName(g.getGiftName());
					gift.setCategory(g.getCategory());
					gift.setPrice(g.getPrice());
					return repo.save(gift);
				})
				.orElseGet(() -> {
					
					return repo.save(g);
				});
		
	}
}
