package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.OrderedProduct;
import com.prototype.meteor.repositories.OrderedProductRepository;

@Service
public class OrderedProductServiceImpl implements OrderedProductService{

	@Autowired
	private OrderedProductRepository orderedProductRepository;
	
	@Override
	public List<OrderedProduct> findAll() {
		return orderedProductRepository.findAll();
	}

	@Override
	public OrderedProduct findById(Integer id) {
		return orderedProductRepository.getOne(id);
	}

	@Override
	public OrderedProduct save(OrderedProduct orderedProduct) {
		return orderedProductRepository.save(orderedProduct);
	}

	@Override
	public OrderedProduct delete(OrderedProduct orderedProduct) {
		orderedProductRepository.delete(orderedProduct);
		return orderedProduct;
	}

	@Override
	public OrderedProduct update(Integer id, OrderedProduct orderedProduct) {
		if (orderedProduct == null) {
			return null;
		}
		OrderedProduct orderedProductFromDb = orderedProductRepository.getOne(id);
		if (orderedProductFromDb == null) {
			return null;
		}
		if(orderedProduct.getName() != null) {
			orderedProductFromDb.setName(orderedProduct.getName());
		}
		if (orderedProduct.getDescription() != null) {
			orderedProductFromDb.setDescription(orderedProduct.getDescription());
		}
		if (orderedProduct.getMeasurementUnit() != null) {
			orderedProductFromDb.setMeasurementUnit(orderedProduct.getMeasurementUnit());
		}
		if (orderedProduct.getOrder() != null) {
			orderedProductFromDb.setOrder(orderedProduct.getOrder());
		}
		if (orderedProduct.getPrice() != 0.0f) {
			orderedProductFromDb.setPrice(orderedProduct.getPrice());
		}
		if (orderedProduct.getSecondaryMU() != null) {
			orderedProductFromDb.setSecondaryMU(orderedProduct.getSecondaryMU());
		}
		if (orderedProduct.getTva() != 0) {
			orderedProductFromDb.setTva(orderedProduct.getTva());
		}
		
		orderedProductRepository.save(orderedProductFromDb);
		return orderedProduct;
	}

	@Override
	public List<OrderedProduct> findAllProductsForOrder(Order order) {
		return  order.getOrderedProducts();
	}

}
