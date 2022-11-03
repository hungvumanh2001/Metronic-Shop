package com.example.metronicshop.repository;

import com.example.metronicshop.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    @Query("select new com.example.metronicshop.model.Receipt(u, true) from Receipt u where u.user.id = ?1")
    List<Receipt> findAllByUserId(Long userId);

    @Query("select new com.example.metronicshop.model.Receipt(u, true) from Receipt u")
    List<Receipt> findAll();

}
