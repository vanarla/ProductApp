package com.capgemini.product.service;


import com.capgemini.product.exceptions.ProductNotFoundException;
import com.capgemini.product.modal.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product findProductById(int productId) throws ProductNotFoundException;
	public void deleteProduct(Product product);
}
