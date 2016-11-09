/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovasFuncionalidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.CategoriaInexistenteException;
import exception.ProdutoInexistenteException;
import exception.ProdutosDiferentesException;
import genus.Tipos.Categoria;
import genus.Tipos.Produto;
import genus.Tipos.Venda;

/**
 *
 * @author Heráclito Júnior
 */
public class FuncionalidadesNovas {
	
	List<Produto> listaDeProdutos;
	List<Categoria> listaDeCategorias;
	
	public FuncionalidadesNovas(){
		
    	listaDeProdutos=new ArrayList<Produto>();
    	listaDeCategorias = new ArrayList<Categoria>();
    	
		Produto produtoAuxiliar;
		Categoria categoriaAuxiliar;
		
		categoriaAuxiliar = new Categoria(1, "vegetais");
		listaDeCategorias.add(categoriaAuxiliar);
		categoriaAuxiliar = new Categoria(2, "informatica");
		listaDeCategorias.add(categoriaAuxiliar);
		categoriaAuxiliar = new Categoria(3, "limpeza");
		listaDeCategorias.add(categoriaAuxiliar);
		categoriaAuxiliar = new Categoria(4, "farmacia");
		listaDeCategorias.add(categoriaAuxiliar);
		categoriaAuxiliar = new Categoria(5, "cosmeticos");
		listaDeCategorias.add(categoriaAuxiliar);
		
		produtoAuxiliar = new Produto(1, "tomate", 91, 0.5, 1);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(2, "laranja", 106, 0.4, 1);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(3, "mouse", 30, 20.5, 2);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(4, "teclado", 25, 50.5, 2);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(5, "detergente", 100, 2.5, 3);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(6, "sabao", 100, 1.5, 3);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(7, "absorvente", 70, 19.5, 4);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(8, "analgesico", 60, 15.5, 4);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(9, "batom", 50, 15.5, 5);
		listaDeProdutos.add(produtoAuxiliar);
		produtoAuxiliar = new Produto(10, "perfume", 25, 25.5, 5);
		listaDeProdutos.add(produtoAuxiliar); 
	}
	
	public Produto retornarProdutoPorID(int idProduto) throws UnsupportedOperationException{
		
		for(Produto produto : listaDeProdutos){
			if(produto.getIDproduto() == idProduto){
				return produto;
			}
		}
		throw new ProdutoInexistenteException();
	}
	
public Produto retornarProdutoPorNome(String nomeProduto) throws UnsupportedOperationException{
		
		for(Produto produto : listaDeProdutos){
			if(produto.getNome() == nomeProduto){
				return produto;
			}
		}
		throw new ProdutoInexistenteException();
	}
	
	public Desconto retornarDescontoPorID(int idDesconto){
		
		/*for(Desconto desconto : listaDeDescontos){
			if(produto.getIDdesconto() == idDesconto){
				return desconto;
			}
		}*/
		
		throw new UnsupportedOperationException();
	}
	
	public Categoria retornarCategoriaPorID(int idCategoria){
		
		for(Categoria categoria : listaDeCategorias){
			if(categoria.getIDcategoria() == idCategoria){
				return categoria;
			}
		}
		throw new CategoriaInexistenteException();
	}
	
	public Lotes retornarLotesPorID(int idLote){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Produto calcularDescontoProduto(Produto produtoParaCalcular,List<Desconto> listaDeDescontosParaCalcular,List<Produto> listaEstoque){
		Produto produtoRetornado=new Produto();
		int achouDesconto=-1;
		
		if(!(listaEstoque.contains(produtoParaCalcular))){
			
			throw new ProdutoInexistenteException();
		}
		
		for(int i=0;i<listaDeDescontosParaCalcular.size();i++){
			if(listaDeDescontosParaCalcular.get(i).getIDProduto()==produtoParaCalcular.getIDproduto()){
				achouDesconto=i;
				break;
			}			
		}
		if(achouDesconto!=-1){
			double proporcaoDesconto=(1-(listaDeDescontosParaCalcular.get(achouDesconto).getPorcentagem()));
			double armazenarResultado=produtoParaCalcular.getPreco()*proporcaoDesconto;
			produtoRetornado.setIDproduto(produtoParaCalcular.getIDproduto());
			produtoRetornado.setNome(produtoParaCalcular.getNome());
			produtoRetornado.setQuantidade(produtoParaCalcular.getQuantidade());
			produtoRetornado.setIDCategoria(produtoParaCalcular.getIDCategoria());
			produtoRetornado.setPreco(armazenarResultado);
			
			return produtoRetornado;
			
		}
		produtoRetornado.setIDproduto(produtoParaCalcular.getIDproduto());
		produtoRetornado.setNome(produtoParaCalcular.getNome());
		produtoRetornado.setQuantidade(produtoParaCalcular.getQuantidade());
		produtoRetornado.setIDCategoria(produtoParaCalcular.getIDCategoria());
		produtoRetornado.setPreco(produtoParaCalcular.getPreco());
		
		return produtoRetornado;
		
		
		
	}
	

	

	
	
	
	public List<VendaContemPromocao> setarVendaContem(VendaModificada novaVenda,List<Desconto> listaDescontos){
		List<VendaContemPromocao> novoVendaContem=new ArrayList<VendaContemPromocao>();
		List<Produto> carrinho=new ArrayList<Produto>();
		List<Produto> estoque=new ArrayList<Produto>();
		carrinho=novaVenda.getListaDeProdutos();
		estoque=novaVenda.getEstoque();
		
		boolean descontoEncontradoInteracao=false;
		int idDaPromocao=-1;
		int PosicaoDesconto=-1;
		for(int i=0;i<carrinho.size();i++){
			idDaPromocao=-1;
			PosicaoDesconto=-1;
			descontoEncontradoInteracao=false;
			for(int j=0;j<listaDescontos.size();j++){
				if(carrinho.get(i).getIDproduto()==listaDescontos.get(j).getIDProduto()){
					idDaPromocao=listaDescontos.get(j).IDdesconto;
					PosicaoDesconto=j;
				}
			}
			
			
			if(idDaPromocao==-1){
				int interador=-1;
				
				for(int k=0;k<estoque.size();k++){
					if(carrinho.get(i).getIDproduto()==estoque.get(k).getIDproduto()){
						interador=k;
					}
				}
				
				double precoNormal=estoque.get(interador).getPreco();
				novoVendaContem.add(new VendaContemPromocao(novaVenda.getIDvenda(), carrinho.get(i).getIDproduto(), novaVenda.getQuantidadeDeProdutos().get(i), precoNormal, precoNormal, 0));
			}else{
				int interador=-1;
				
				for(int k=0;k<estoque.size();k++){
					if(carrinho.get(i).getIDproduto()==estoque.get(k).getIDproduto()){
						interador=k;
					}
				}
				double precoNormal=estoque.get(interador).getPreco();
				
				
				novoVendaContem.add(new VendaContemPromocao(novaVenda.getIDvenda(), carrinho.get(i).getIDproduto(), novaVenda.getQuantidadeDeProdutos().get(i), precoNormal,carrinho.get(i).getPreco() ,idDaPromocao));
			}
			
			
		}
		return novoVendaContem;
				
		
	}
	public void setarLotes(List<Lotes> listaLotes,Date dataAtual){
		
		throw new UnsupportedOperationException();
		
	}
	
}
