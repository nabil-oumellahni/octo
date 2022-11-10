package com.octoproject.service;

public interface IAuditService {
    void auditTransfer(String message);
    void auditDeposit(String message);
}
