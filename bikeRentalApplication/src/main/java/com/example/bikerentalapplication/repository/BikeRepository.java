package com.example.bikerentalapplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bikerentalapplication.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Long> {
	//public boolean existsByvenueName(String venueName);
	boolean existsByBikeNumber(String bikeNumber);
}
