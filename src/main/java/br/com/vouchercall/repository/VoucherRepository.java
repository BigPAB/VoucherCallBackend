package br.com.vouchercall.repository;

import br.com.vouchercall.model.Voucher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    List<Voucher> findAllByCalled(boolean called);
}
