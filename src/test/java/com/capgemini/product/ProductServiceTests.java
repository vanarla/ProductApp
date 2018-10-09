package com.capgemini.product;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.product.exceptions.ProductNotFoundException;
import com.capgemini.product.modal.Product;
import com.capgemini.product.repository.ProductRepository;
import com.capgemini.product.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {
	
  @Mock
  ProductRepository productRepository;
	
  @InjectMocks
  ProductServiceImpl productServiceImpl;
  
  private MockMvc mockMvc;
 private  Product product;
  
  @Before
public void setUp()
{
	  MockitoAnnotations.initMocks(this);
	  mockMvc=MockMvcBuilders.standaloneSetup().build();
	
}
  @Test
  public void addProductTest() {
	  
	  Product product1 = new Product(10, "Chocolate", "Food", 30.0);
		when(productRepository.save(product1)).thenReturn(product1);
		assertEquals(productServiceImpl.addProduct(product1), product1);
  }
  
  @Test
  public void updateProductTest() {
	  
	  Product pro=new Product(10, "Chocolate", "Food", 30.0);
		Product pro1=new Product(10, "Chocolate", "Food", 30.0);
		
		when(productRepository.save(pro)).thenReturn(pro1);
		assertEquals(productServiceImpl.updateProduct(pro), pro1);
  }
  
  @Test
  public void findProductByIdTest() throws ProductNotFoundException {
	  
	  Product product2 = new Product(10, "Chocolate", "Food", 30.0);
		Optional<Product> product3 = Optional.of(product2);
		when(productRepository.findById(20)).thenReturn(product3);
		assertEquals(productServiceImpl.findProductById(20), product2);
	  
  }

  @Test
	public void testdeleteproduct() throws Exception {
		productServiceImpl.deleteProduct(product);
		//verify(productRepository,times(1)).deleteById(10);
	}
	

}
