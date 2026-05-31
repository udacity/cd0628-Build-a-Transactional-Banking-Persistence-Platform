package com.udacity.banking.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.banking.entity.AuditLog;
import com.udacity.banking.repository.AuditLogRepository;

/**
 * Service for recording audit log events.
 *
 * EXERCISE: Implement recordEvent so the audit row is always committed, 
 * EVEN if the caller's transaction (e.g. a transfer) rolls back.
 *
 * The AuditLogServiceTest verifies that when a transfer fails with
 * InsufficientFundsException, the audit row count still increases by 1.
 * This only works if recordEvent runs in an independent transaction —
 * the REQUIRES_NEW pattern.
 */
@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    /**
     * Record an audit message in its own transaction (REQUIRES_NEW).
     *
     * @param message the audit message to record
     *
     * TODO: Add @Transactional with propagation = Propagation.REQUIRES_NEW
     *       Then create a new AuditLog with the message and current timestamp,
     *       and save it via auditLogRepository.
     */
    public void recordEvent(String message) {
        // TODO: implement this method
        throw new UnsupportedOperationException("Not yet implemented");
    }
}