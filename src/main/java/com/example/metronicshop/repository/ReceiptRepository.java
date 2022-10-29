package com.example.metronicshop.repository;

import com.example.metronicshop.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Long countByUserIdAndStatus(Long userId, int status);
}
