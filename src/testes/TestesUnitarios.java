package testes;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activity.InvalidActivityException;
import javax.management.BadAttributeValueExpException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mysql.fabric.xmlrpc.base.Data;

import NovasFuncionalidades.Desconto;
import NovasFuncionalidades.FuncionalidadesNovas;
import NovasFuncionalidades.VendaContemPromocao;
import NovasFuncionalidades.VendaModificada;
import exception.CategoriaInexistenteException;
import exception.ProdutoInexistenteException;
import exception.ValorInvalidoException;
import genus.Funcoes;
import genus.Tipos.Categoria;
import genus.Tipos.Funcionario;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

public class TestesUnitarios {
	
	@Mock
	private FuncionalidadesNovas novasFuncionalidades;
	

	FuncionalidadesNovas funcionalidadesNovas;
	
	//@Mock
	//private VendaModificada novaVenda;
	
	List<Produto> listaDeProdutos;
	List<Desconto>listaDeDescontos;
	List<String>lista;
	Date dataAtual;
	
    @SuppressWarnings("deprecation")
	@Before
	public void initialize() {
    	MockitoAnnotations.initMocks(this);
    	listaDeProdutos=new ArrayList<Produto>();
		listaDeDescontos=new ArrayList<Desconto>();
		//listaDeVendaContem=new ArrayList<VendaContemPromocao>();
		
		funcionalidadesNovas = new FuncionalidadesNovas();
		
		Produto auxiliarParaAlocacaoProdutos;
    	
		when(novasFuncionalidades.retornarProdutoPorID(1)).thenReturn(new Produto(1, "tomate", 91, 0.5, 1));
		when(novasFuncionalidades.retornarProdutoPorID(2)).thenReturn(new Produto(2, "laranja", 106, 0.4, 1));
		when(novasFuncionalidades.retornarProdutoPorID(3)).thenReturn(new Produto(3, "mouse", 30, 20.5, 2));
		when(novasFuncionalidades.retornarProdutoPorID(4)).thenReturn(new Produto(4, "teclado", 25, 50.5, 2));
		when(novasFuncionalidades.retornarProdutoPorID(5)).thenReturn(new Produto(5, "detergente", 100, 2.5, 3));
		when(novasFuncionalidades.retornarProdutoPorID(6)).thenReturn(new Produto(6, "sabao", 100, 1.5, 3));
		when(novasFuncionalidades.retornarProdutoPorID(7)).thenReturn(new Produto(7, "absorvente", 70, 19.5, 4));
		when(novasFuncionalidades.retornarProdutoPorID(8)).thenReturn(new Produto(8, "analgesico", 60, 15.5, 4));
		when(novasFuncionalidades.retornarProdutoPorID(9)).thenReturn(new Produto(9, "batom", 50, 15.5, 5));
		when(novasFuncionalidades.retornarProdutoPorID(10)).thenReturn(new Produto(10, "perfume", 25, 25.5, 5));
	
		for(int j=1;j<=10;j++){
			auxiliarParaAlocacaoProdutos=novasFuncionalidades.retornarProdutoPorID(j);
			listaDeProdutos.add(auxiliarParaAlocacaoProdutos);
		}  
    }
    
    
    @Test
	public void testBuscarProdutoIDValido() {
    	
    	Produto produtoAuxiliar;
    	boolean existeProduto;
    	FuncionalidadesNovas funcionalidadesNovas = new FuncionalidadesNovas();
    	
    	produtoAuxiliar = novasFuncionalidades.retornarProdutoPorID(1);
    	existeProduto = listaDeProdutos.get(0).equals(produtoAuxiliar);
		assertEquals(true, existeProduto);
		
    	produtoAuxiliar = novasFuncionalidades.retornarProdutoPorID(3);
    	existeProduto = listaDeProdutos.get(2).equals(produtoAuxiliar);
		assertEquals(true, existeProduto);

    	produtoAuxiliar = novasFuncionalidades.retornarProdutoPorID(5);
    	existeProduto = listaDeProdutos.get(4).equals(produtoAuxiliar);
		assertEquals(true, existeProduto);

    	produtoAuxiliar = novasFuncionalidades.retornarProdutoPorID(10);
    	existeProduto = listaDeProdutos.get(9).equals(produtoAuxiliar);
		assertEquals(existeProduto, true);
		
	}
    
    @Test(expected=ProdutoInexistenteException.class)
	public void testBuscarProdutoIDInvalido() {
    	
    	Produto produtoAuxiliar;
    	boolean existeProduto;
    	
    	FuncionalidadesNovas funcionalidadesNovas = new FuncionalidadesNovas();
    	
    	produtoAuxiliar = funcionalidadesNovas.retornarProdutoPorID(11);
		
	}
    
    @Test
    public void testAtualizarProdutoNomePrecoCategoria() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	assertNotEquals(produtoAuxiliar.getNome(), "NovoNome");
    	assertNotEquals(produtoAuxiliar.getPreco(), 13.13);
    	assertNotEquals(produtoAuxiliar.getIDCategoria(), 1);
    	
    	produtoAuxiliar.setNome("NovoNome");
    	produtoAuxiliar.setPreco(13.13);
    	produtoAuxiliar.setIDCategoria(1);
    	
    	assertEquals(produtoAuxiliar.getNome(), "NovoNome");
    	assertEquals(produtoAuxiliar.getPreco(), 13.13, 0.001);
    	assertEquals(produtoAuxiliar.getIDCategoria(), 1);

    }
    
    @Test
    public void testAtualizarProdutoPrecoCategoria() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	assertNotEquals(produtoAuxiliar.getPreco(), 13.13);
    	assertNotEquals(produtoAuxiliar.getIDCategoria(), 1);
    	
    	produtoAuxiliar.setPreco(13.13);
    	produtoAuxiliar.setIDCategoria(1);
    	
    	assertEquals(produtoAuxiliar.getPreco(), 13.13, 0.001);
    	assertEquals(produtoAuxiliar.getIDCategoria(), 1);

    }
    
    @Test
    public void testAtualizarProdutoNomeCategoria() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	assertNotEquals(produtoAuxiliar.getNome(), "NovoNome");
    	assertNotEquals(produtoAuxiliar.getIDCategoria(), 1);
    	
    	produtoAuxiliar.setNome("NovoNome");
    	produtoAuxiliar.setIDCategoria(1);
    	
    	assertEquals(produtoAuxiliar.getNome(), "NovoNome");
    	assertEquals(produtoAuxiliar.getIDCategoria(), 1);

    }
    
    @Test
    public void testAtualizarProdutoNomePreco() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	assertNotEquals(produtoAuxiliar.getNome(), "NovoNome");
    	assertNotEquals(produtoAuxiliar.getPreco(), 13.13);
    	
    	produtoAuxiliar.setNome("NovoNome");
    	produtoAuxiliar.setPreco(13.13);
    	
    	assertEquals(produtoAuxiliar.getNome(), "NovoNome");
    	assertEquals(produtoAuxiliar.getPreco(), 13.13, 0.001);

    }
    
    @Test
    public void testAtualizarProdutoNome() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	assertNotEquals(produtoAuxiliar.getNome(), "NovoNome");
    	
    	produtoAuxiliar.setNome("NovoNome");
    	
    	assertEquals(produtoAuxiliar.getNome(), "NovoNome");

    }
    
    @Test
    public void testAtualizarProdutoPreco() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	assertNotEquals(produtoAuxiliar.getPreco(), 13.13);
    	
    	produtoAuxiliar.setPreco(13.13);
    	
    	assertEquals(produtoAuxiliar.getPreco(), 13.13, 0.001);

    }
    
    @Test
    public void testAtualizarProdutoCategoria() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	assertNotEquals(produtoAuxiliar.getIDCategoria(), 1);
    	
    	produtoAuxiliar.setIDCategoria(1);
    	
    	assertEquals(produtoAuxiliar.getIDCategoria(), 1);

    }
    
    @Test(expected=ValorInvalidoException.class)
    public void testAtualizarProdutoPrecoInvalido() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	produtoAuxiliar.setPreco(-0.1);

    }
    
    @Test(expected=CategoriaInexistenteException.class)
    public void testAtualizarProdutoCategoriaInvalida() {
    	
    	Produto produtoAuxiliar = listaDeProdutos.get(5);
    	
    	Categoria categoriaAuxiliar = funcionalidadesNovas.retornarCategoriaPorID(10);
    	
    	produtoAuxiliar.setIDCategoria(10);

    }
    
    @Test
    public void testInserirVendaPorCodigo() {
    	
    }
    
    @Test
    public void testInserirVendaPorNome() {
    	
    }
    
    @Test
    public void testInserirVendaPorCodigoNome() {
    	
    }

}
