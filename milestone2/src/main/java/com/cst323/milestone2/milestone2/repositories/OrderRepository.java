package com.cst323.milestone2.milestone2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cst323.milestone2.milestone2.models.order;

public interface OrderRepository extends JpaRepository<order, Long> {
    
}
