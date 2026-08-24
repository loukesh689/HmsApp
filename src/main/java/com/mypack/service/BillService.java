package com.mypack.service;

import com.mypack.entity.Bill;
import com.mypack.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository repository;
    // save bill
    public Bill saveBill(Bill b){
        return repository.save(b);
    }
    // get All
    public List<Bill> getAllBills(){
        return  repository.findAll();
    }
    public Bill getBillById(Long id){
        return repository.findById(id)
                .orElseThrow(()->new RuntimeException("bill not found wit id "));
    }
    public Bill updateBillById(Bill b){
        return repository.save(b);

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
