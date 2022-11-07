package com.example.metronicshop.repository;

import com.example.metronicshop.model.ReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Long> {
    @Query("Select new com.example.metronicshop.model.ReceiptDetail(u,true) from ReceiptDetail u where u.receipt.id = ?1")
    List<ReceiptDetail> findAllByReceiptId(Long receiptId);
}
