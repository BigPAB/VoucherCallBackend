package br.com.vouchercall.service;

import br.com.vouchercall.model.Voucher;
import br.com.vouchercall.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {

    private VoucherRepository repository;

    public VoucherService (VoucherRepository repository) {
        this.repository = repository;
    }

    public Voucher generateVoucher(Voucher voucher) {
        repository.save(voucher);
        return voucher;
    }

    public void deleteVouchers() {
        repository.deleteAll();
    }

    public List<Voucher> listVouchers(Boolean called) {
        return repository.findAllByCalled(called);
    }

    public Long getCount() {
        return repository.count();
    }
}
