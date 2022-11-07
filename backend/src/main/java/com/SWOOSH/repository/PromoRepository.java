package com.SWOOSH.repository;

import com.SWOOSH.Promocodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promocodes, Integer> {

}
