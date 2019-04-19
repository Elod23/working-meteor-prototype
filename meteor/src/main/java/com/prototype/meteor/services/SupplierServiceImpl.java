package com.prototype.meteor.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.domain.SupplierDTO;
import com.prototype.meteor.entities.GenericBuilder;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.Supplier;
import com.prototype.meteor.repositories.SupplierRepository;

@Service
public class SupplierServiceImpl implements SupplierService {

	public static Logger logger = LogManager.getFormatterLogger();

	@Autowired
	private SupplierRepository supplierRepository;

	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}
	
	/*
	 * Converting DToToDb And Backwards(non-Javadoc)
	 * @see com.prototype.meteor.services.SupplierService#save(com.prototype.meteor.entities.Supplier)
	 */
	private SupplierDTO convertToDTO(Supplier supplier) {
		
		if(supplier != null) {
		SupplierDTO supplierDTO = GenericBuilder.of(SupplierDTO::new)
									.with(SupplierDTO::setName, supplier.getName())
									.with(SupplierDTO::setCUI, supplier.getcUI())
									.with(SupplierDTO::setLogoURL, supplier.getSupplierLogoURL())
									.with(SupplierDTO::setProducts, supplier.getProducts())
									.build();
		
		return supplierDTO;
		}else {
			logger.info("The  Supplier asked for does not exist in the Database", supplier.getcUI());
			return null;
		}
	}
	
	private Supplier convertToDb(SupplierDTO supplier) {
		
		if(supplier != null) {
		Supplier supplierDb = GenericBuilder.of(Supplier::new)
								.with(Supplier::setName, supplier.getName())
								.with(Supplier::setcUI, supplier.getCUI())
								.with(Supplier::setSupplierLogoURL, supplier.getLogoURL())
								.with(Supplier::setProducts, supplier.getProducts())
								.build();
		return supplierDb;
		}else {
			logger.info("The given SupplierDTO input object is null", supplier);
			return null;
		}
	}
	

	@Override
	public Supplier save(SupplierDTO supplier) {
		if (supplier != null) {
			Supplier supplierDb  = this.convertToDb(supplier);
			return supplierRepository.save(supplierDb);
		} else {
			logger.info("Supplier object gives as parameter was null", supplier);
			return null;
		}
	}

	@Override
	public Supplier update(SupplierDTO supplier) {
		if (supplier == null) {
			logger.info("Supplier object given as parameter was null, nothing to update", supplier);
			return null;
		} else {
			Supplier supplierDb = this.convertToDb(supplier);
			
			supplierRepository.delete(supplierDb);
			return supplierRepository.save(supplierDb);
		}
	}

	@Override
	public Supplier delete(SupplierDTO supplier) {
		if (supplier == null) {
			logger.info("Supplier object given as parameter was null, there is no id to be deleted for", supplier);
		} else {
			
			Supplier supplierDb = this.convertToDb(supplier);
			supplierRepository.delete(supplierDb);
			logger.info("Deleted Supplier :" + supplier.toString());
			return supplierDb;
		}
		return null;
	}

	@Override
	public List<SupplierDTO> findAll() {
		List<Supplier> suppliers = supplierRepository.findAll();
		List<SupplierDTO> suppliersDisplayed = new ArrayList<>();
		for(Supplier supplier: suppliers) {
			suppliersDisplayed.add(this.convertToDTO(supplier));
		}
		return suppliersDisplayed;
	}

	@Override
	public List<SupplierDTO> findByExactCUI(String CUI) {
		if (CUI == null) {
			logger.info("The given CUI as param was null, there is no String to be searched after", CUI);
			return null;
		} else {
			
			List<Supplier> suppliers = supplierRepository.findByCUIIgnoreCase(CUI);
			List<SupplierDTO> suppliersDisplayed = new ArrayList<>();
			for(Supplier supplier: suppliers) {
				suppliersDisplayed.add(this.convertToDTO(supplier));
			}
			return suppliersDisplayed;
		}
	}

	@Override
	public List<SupplierDTO> findByCUIIgnoreCase(String CUI) {
		if (CUI == null) {
			logger.info("The given CUI as param was null, there is no String to be searched after", CUI);
			return null;
		} else {
			List<Supplier> suppliers = supplierRepository.findByCUIIgnoreCaseLike(CUI);
			List<SupplierDTO> suppliersDisplayed = new ArrayList<>();
			for(Supplier supplier: suppliers) {
				suppliersDisplayed.add(this.convertToDTO(supplier));
			}
			return suppliersDisplayed;
		}
	}

	@Override
	public List<SupplierDTO> findByNameIgnoreCase(String name) {
		if (name == null) {
			logger.info("The given name String parameter was null, ther eis nothing to be seached after", name);
			return null;
		} else {
			List<Supplier> suppliers = supplierRepository.findByNameIgnoreCase(name);
			List<SupplierDTO> suppliersDisplayed = new ArrayList<>();
			for(Supplier supplier: suppliers) {
				suppliersDisplayed.add(this.convertToDTO(supplier));
			}
			return suppliersDisplayed;
		}
	}

	@Override
	public List<SupplierDTO> findByNameIgnoreCaseLike(String name) {
		if (name == null) {
			logger.info("The given name String parameter was null, ther eis nothing to be seached after", name);
			return null;
		} else {
			List<Supplier> suppliers = supplierRepository.findByNameIgnoreCaseLike(name);
			List<SupplierDTO> suppliersDisplayed = new ArrayList<>();
			for(Supplier supplier: suppliers) {
				suppliersDisplayed.add(this.convertToDTO(supplier));
			}
			return suppliersDisplayed;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.prototype.meteor.services.SupplierService#findByProducts(java.util.List)
	 * Returns null if there are no products assigned to the supplier
	 */
	@Override
	public SupplierDTO findByProducts(List<Product> products) {

		if (products != null && products.size() != 0) {
			Supplier supplierDb = supplierRepository.findByProducts(products);
			
			
			return this.convertToDTO(supplierDb);
		} else
			return null;
	}
	
	public List<Product> findAllProducts(SupplierDTO supplier){
		return supplier.getProducts();
	}
	
	

}
