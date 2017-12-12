package sg.edu.iss.team8.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.team8.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> findAllSupplier();

}