package com.octoproject.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRANSFER")
public class AuditTransfer extends Audit {
}
