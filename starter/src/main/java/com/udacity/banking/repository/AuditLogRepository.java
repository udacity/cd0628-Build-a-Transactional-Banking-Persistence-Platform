package com.udacity.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udacity.banking.entity.AuditLog;

/**
 * Spring Data JPA repository for the audit log entry.
 * This will enable us to use the inherited methods from JPARepository 
 * such as save(), findAll() and count() etc.
 */
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    
}
