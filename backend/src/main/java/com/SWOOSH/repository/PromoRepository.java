package com.SWOOSH.repository;

import com.SWOOSH.Promocodes;
import com.SWOOSH.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<Promocodes, Integer> {

    // @Query("FROM Promocodes p WHERE p.user_id = :user_id AND p.status = true")
    // User findByEmailWithStatusActive(@Param("promo") String promo);
}
