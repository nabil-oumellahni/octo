package com.octoproject.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DEPOSIT")
public class AuditDeposit extends Audit {
}