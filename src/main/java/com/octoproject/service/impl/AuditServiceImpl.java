package com.octoproject.service.impl;

import com.octoproject.domain.AuditDeposit;
import com.octoproject.domain.AuditTransfer;
import com.octoproject.repository.AuditRepository;
import com.octoproject.service.IAuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuditServiceImpl implements IAuditService {

    Logger LOGGER = LoggerFactory.getLogger(AuditServiceImpl.class);

    @Autowired
    private AuditRepository auditRepository;

    @Override
    public void auditTransfer(String message) {
        LOGGER.info("Audit de l'événement TRANSFER");

        AuditTransfer audit = new AuditTransfer();
        audit.setMessage(message);
        auditRepository.save(audit);
    }

    @Override
    public void auditDeposit(String message) {
        LOGGER.info("Audit de l'événement DEPOSIT");

        AuditDeposit audit = new AuditDeposit();
        audit.setMessage(message);
        auditRepository.save(audit);
    }

}
