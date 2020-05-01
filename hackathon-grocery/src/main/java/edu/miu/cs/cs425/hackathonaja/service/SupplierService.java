package edu.miu.cs.cs425.hackathonaja.service;

import org.springframework.data.domain.Page;

import edu.miu.cs.cs425.hackathonaja.model.Supplier;

import java.util.List;

public interface SupplierService {

    public abstract List<Supplier> getAllSuppliers();
    public abstract Page<Supplier> getAllSuppliersPaged(int pageNo);

}
