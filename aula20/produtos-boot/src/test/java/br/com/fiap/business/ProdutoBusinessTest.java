package br.com.fiap.business;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.CategoriaModel;
import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.CategoriaRepository;

@SpringBootTest
public class ProdutoBusinessTest {
	
	@InjectMocks
	public ProdutoBusiness produtoBusiness;
	
	@Mock
	public CategoriaRepository categoriaRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testChangeSkuToUpperCase() {
		
		// GIVEN
		String sku = "123abc";
		String expected = "123ABC";
		
		// WHEN
		String actual = produtoBusiness.changeSkuToUpperCase(sku);
		
		// THEN
		assertEquals("Erro ao transformar o SKU em maiúsculo", expected, actual);
	}
	
	@Test
	public void testAddValueToPrecoWithCategoriaSmartphone() {
		
		// GIVEN
		CategoriaModel categoria = new CategoriaModel(1, "Smartphone");	
		BigDecimal preco = new BigDecimal(10);
		BigDecimal expected = new BigDecimal(20);
		
		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categoria));
		BigDecimal actual = produtoBusiness.addValueToPreco(preco, categoria);
		
		// THEN
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddValueToPrecoWithCategoriaNotebook() {
		
		// GIVEN
		CategoriaModel categoria = new CategoriaModel(1, "Notebook");	
		BigDecimal preco = new BigDecimal(10);
		BigDecimal expected = new BigDecimal(30);
		
		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categoria));
		BigDecimal actual = produtoBusiness.addValueToPreco(preco, categoria);
		
		// THEN
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddValueToPrecoWithoutCategoria() {
		
		// GIVEN
		CategoriaModel categoria = new CategoriaModel(1, null);	
		BigDecimal preco = new BigDecimal(10);
		BigDecimal expected = new BigDecimal(10);
		
		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categoria));
		BigDecimal actual = produtoBusiness.addValueToPreco(preco, categoria);
		
		// THEN
		assertEquals(expected, actual);
	}
	
	@Test(expected = ResponseBusinessException.class)
	public void testVerifyNomeProdutoWithTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Produto Teste";
		
		// WHEN
		produtoBusiness.verifyNomeProduto(nome);
	}
	
	@Test
	public void testVerifyNomeProdutoWithoutTest() throws ResponseBusinessException {
		
		// GIVEN
		String nome = "Produto Normal";
		
		// WHEN
		produtoBusiness.verifyNomeProduto(nome);
	}
	
	@Test
	public void testApplyBusiness() throws ResponseBusinessException {
		
		// GIVEN
		CategoriaModel categoria = new CategoriaModel(1, "Notebook");	
		ProdutoModel produto = new ProdutoModel(1, "Produto Novo", "123abc", "Descricao teste", new BigDecimal(10), "Caracteristica", categoria, null);
		ProdutoModel expected = new ProdutoModel(1, "Produto Novo", "123ABC", "Descricao teste", new BigDecimal(30), "Caracteristica", categoria, null);
		
		// WHEN
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categoria));
		ProdutoModel actual = produtoBusiness.applyBusiness(produto);
		
		// THEN
		assertEquals(expected.toString(), actual.toString());
	}

}
