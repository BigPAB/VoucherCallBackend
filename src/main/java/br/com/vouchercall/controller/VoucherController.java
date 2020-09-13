package br.com.vouchercall.controller;

import br.com.vouchercall.model.Voucher;
import br.com.vouchercall.service.VoucherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voucher")
public class VoucherController {

    private VoucherService service;

    public VoucherController(VoucherService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listVouchers (@RequestParam Boolean called) {
        try {
            List<Voucher> vouchers = service.listVouchers(called);
            return new ResponseEntity<>(vouchers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping
    public ResponseEntity<?> saveVoucher (@RequestBody Voucher voucher) {
        try {
             service.generateVoucher(voucher);
            return new ResponseEntity<>(voucher, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping
    public ResponseEntity<?> editVoucher (@RequestBody Voucher voucher) {
        try {
            service.generateVoucher(voucher);
            return new ResponseEntity<>(voucher, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteVouchers () {
        try {
             service.deleteVouchers();
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> getCount () {
        try {
            Long count = service.getCount();
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
}
