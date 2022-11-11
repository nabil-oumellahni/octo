package com.octoproject.repository;

import com.octoproject.domain.TransactionTransfer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
public class TransactionTransferRepositoryTest {

  @Autowired
  private TransactionTransferRepository transactionTransferRepository;

  @Test
  public void findOne() {
    TransactionTransfer transfer = new TransactionTransfer();
    transfer.setMontant(BigDecimal.valueOf(1000));
    transactionTransferRepository.save(transfer);

    Optional<TransactionTransfer> result = transactionTransferRepository.findById(transfer.getId());

    assertEquals(transfer, result.get());
  }

  @Test
  public void findAll() {
    TransactionTransfer transfer1 = new TransactionTransfer();
    transfer1.setMontant(BigDecimal.valueOf(1000));
    transactionTransferRepository.save(transfer1);

    TransactionTransfer transfer2 = new TransactionTransfer();
    transfer2.setMontant(BigDecimal.valueOf(2000));
    transactionTransferRepository.save(transfer2);

    List<TransactionTransfer> result = transactionTransferRepository.findAll();

    assertNotNull(result);
    assertEquals(3, result.size());
  }

  @Test
  public void save() {
    TransactionTransfer transfer = new TransactionTransfer();
    transfer.setMontant(BigDecimal.valueOf(1234));
    TransactionTransfer saved = transactionTransferRepository.save(transfer);
    assertEquals(saved.getMontant().intValue(), 1234);
  }

  @Test
  public void delete() {
    TransactionTransfer transfer = new TransactionTransfer();
    transfer.setMontant(BigDecimal.valueOf(1000));
    transactionTransferRepository.save(transfer);

    transactionTransferRepository.deleteById(transfer.getId());

    Optional<TransactionTransfer> result = transactionTransferRepository.findById(transfer.getId());

    assertEquals(Optional.empty(), result);
  }

}