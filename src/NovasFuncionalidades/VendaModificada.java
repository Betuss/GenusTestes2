package NovasFuncionalidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.BadAttributeValueExpException;

import exception.ProdutoInexistenteException;
import exception.ProdutoNaoEstaNoCarrinhoException;
import exception.ProdutosDiferentesException;
import exception.QuantidadeInsuficienteException;
import exception.ValorInvalidoException;
import genus.Tipos.Produto;

/**
 *
 * @author junior
 */
public class VendaModificada {
	
	
	List<Produto> listaDeProdutos=new ArrayList<Produto>();
	List<Double> QuantidadeDeProdutos=new ArrayList<Double>();
	List<Produto> estoque=new ArrayList<Produto>();

	int IDvenda;
    int IDvendedor;
    int IDcliente = 0;
    double ValorTotal;
    Date dataVenda;
	
	
	
	public VendaModificada() {
		
    }

    public VendaModificada(int IDvenda, int IDvendedor) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        ValorTotal = 0;
    }

    public VendaModificada(int IDvenda, int IDvendedor, double ValorTotal) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        this.ValorTotal = ValorTotal;
    }

    public VendaModificada(int IDvenda, int IDvendedor, int IDcliente, double ValorTotal) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        this.ValorTotal = ValorTotal;
        this.IDcliente = IDcliente;
    }
    
    public VendaModificada(int IDvenda, int IDvendedor, int IDcliente, double ValorTotal,Date novaData) {
        this.IDvenda = IDvenda;
        this.IDvendedor = IDvendedor;
        this.ValorTotal = ValorTotal;
        this.IDcliente = IDcliente;
        this.dataVenda=novaData;
    }

    public int getIDvenda() {
        return IDvenda;
    }
    
    public int getIDvendedor() {
    	return IDvendedor;
    }
    
    public int getIDcliente() {
    	return IDcliente;
    }
    
    public void setIDcliente(int novoCliente) {
    	this.IDcliente = novoCliente;
    }

    public void atualizaValorTotal(double valor){
        valor = Math.round(valor * 100.0) / 100.0;
        ValorTotal += valor;
    }
    
    public double getValorTotal() {
        ValorTotal = Math.round(ValorTotal * 100.0) / 100.0;
        return ValorTotal;
    }

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}
	
	public List<Double> getListaDeQuantidades() {
		return QuantidadeDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
    public List<Double> getQuantidadeDeProdutos() {
		return QuantidadeDeProdutos;
	}

	public void setQuantidadeDeProdutos(List<Double> quantidadeDeProdutos) {
		QuantidadeDeProdutos = quantidadeDeProdutos;
	}
	
	public void adicionarAVenda(Produto produtoParaVenda, double novaQuantidade){
		
		if(novaQuantidade<=0.0){
			throw new ValorInvalidoException();
		}
		
		int localNoCarrinho=-1;
		Produto produtoParaComparacao=new Produto();
		int index;
		int localEstoque=-1;
		
		for(int j=0;j<estoque.size();j++){
			if(estoque.get(j).getIDproduto()==produtoParaVenda.getIDproduto()){
				localEstoque=j;
				break;
			}
		}
		
		if(localEstoque==-1){
			
			throw new ProdutoInexistenteException();
		}else{
			produtoParaComparacao.setIDproduto(estoque.get(localEstoque).getIDproduto());
			
			produtoParaComparacao.setNome(estoque.get(localEstoque).getNome());
			produtoParaComparacao.setQuantidade(estoque.get(localEstoque).getQuantidade());
			produtoParaComparacao.setIDCategoria(estoque.get(localEstoque).getIDCategoria());
			produtoParaComparacao.setPreco(estoque.get(localEstoque).getPreco());
			
			
		}
		
		
		if(novaQuantidade>produtoParaComparacao.getQuantidade()){
			throw new QuantidadeInsuficienteException();
		}
		
		if(!listaDeProdutos.contains(produtoParaVenda)){
			listaDeProdutos.add(produtoParaVenda);
			QuantidadeDeProdutos.add(novaQuantidade);
			atualizaValorTotal(produtoParaVenda.getPreco() * novaQuantidade);
			return;
			
		}else{
			localNoCarrinho=listaDeProdutos.indexOf(produtoParaVenda);
			double quantidadeAtual=QuantidadeDeProdutos.get(localNoCarrinho);
			if((quantidadeAtual+novaQuantidade)>produtoParaComparacao.getQuantidade()){
				
				throw new QuantidadeInsuficienteException();
			}
			QuantidadeDeProdutos.set(localNoCarrinho, quantidadeAtual+novaQuantidade);
			atualizaValorTotal(produtoParaVenda.getPreco() * novaQuantidade);
			return;
		}

	}


	public void removerDaVenda(Produto produtoParaTestarRmv, double quantidade) {
		
		// TODO Auto-generated method stub
		
		int localNoCarrinho=-1;
		
		if(quantidade<=0.0){
			throw new ValorInvalidoException();
		}
		
		
		if(!(estoque.contains(produtoParaTestarRmv))){
			
			throw new ProdutoInexistenteException();
		}
		
		if(!(listaDeProdutos.contains(produtoParaTestarRmv))){
			
			throw new ProdutoNaoEstaNoCarrinhoException();
		}
		
		
		localNoCarrinho=listaDeProdutos.indexOf(produtoParaTestarRmv);
		
		if(quantidade>QuantidadeDeProdutos.get(localNoCarrinho)){
			throw new QuantidadeInsuficienteException();
		}else if(quantidade==QuantidadeDeProdutos.get(localNoCarrinho)){
			
			
				listaDeProdutos.remove(localNoCarrinho);
				QuantidadeDeProdutos.remove(localNoCarrinho);
				
				return;
		}else{
			
			double quantidadeAtual=QuantidadeDeProdutos.get(localNoCarrinho);
			QuantidadeDeProdutos.set(localNoCarrinho, quantidadeAtual-quantidade);

			return;
		}
		
		
		
		
	}
	
	public void finalizarVenda(int idVendaNovo,int vendedorNovo,int  clienteNovo,Date dataNova ) {
		ValorTotal=0;
		this.IDvenda=idVendaNovo;
		this.IDvendedor=vendedorNovo;
		this.IDcliente=clienteNovo;
		this.dataVenda=dataNova;
		for(int i=0;i<listaDeProdutos.size();i++){
			
			for(int j=0;j<estoque.size();j++){
				if(listaDeProdutos.get(i).getIDproduto()==estoque.get(j).getIDproduto()){
					
					double atual=estoque.get(j).getQuantidade();
					double noCarinho=QuantidadeDeProdutos.get(i);
					double diferenca=atual-noCarinho;
					Produto produtoModificado=estoque.get(j);
					produtoModificado.setQuantidade(diferenca);
			}
		}
			
			
		}
		
		
		
		for(int i=0;i<listaDeProdutos.size();i++){
			
			double precoADDquantidade=(listaDeProdutos.get(i).getPreco())*(QuantidadeDeProdutos.get(i));
			
			ValorTotal+=precoADDquantidade;
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}


	public void finalizarVendaComLotes(int idVendaNovo,int vendedorNovo,int  clienteNovo,Date dataNova,List<Lotes> listaDeLotes ) {
		throw new UnsupportedOperationException();
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	public List<Produto> getEstoque() {
		return estoque;
	}

	public void setEstoque(List<Produto> estoque) {
		this.estoque = estoque;
	}

	
public void adicionarAVenda(Produto produtoA, Produto produtoB, double novaQuantidade) throws ProdutosDiferentesException{
		
		if(novaQuantidade<=0.0){
			throw new ValorInvalidoException();
		}
		
		if(produtoA != produtoB){
			throw new ProdutosDiferentesException();
		}
		
		int localNoCarrinho=-1;
		Produto produtoParaComparacao=new Produto();
		int index;
		int localEstoque=-1;
		
		for(int j=0;j<estoque.size();j++){
			if(estoque.get(j).getIDproduto()==produtoA.getIDproduto()){
				localEstoque=j;
				break;
			}
		}
		
		if(localEstoque==-1){
			
			throw new ProdutoInexistenteException();
		}else{
			produtoParaComparacao.setIDproduto(estoque.get(localEstoque).getIDproduto());
			
			produtoParaComparacao.setNome(estoque.get(localEstoque).getNome());
			produtoParaComparacao.setQuantidade(estoque.get(localEstoque).getQuantidade());
			produtoParaComparacao.setIDCategoria(estoque.get(localEstoque).getIDCategoria());
			produtoParaComparacao.setPreco(estoque.get(localEstoque).getPreco());
			
			
		}
		
		
		if(novaQuantidade>produtoParaComparacao.getQuantidade()){
			throw new QuantidadeInsuficienteException();
		}
		
		if(!listaDeProdutos.contains(produtoA)){
			listaDeProdutos.add(produtoA);
			QuantidadeDeProdutos.add(novaQuantidade);
			
			return;
			
		}else{
			localNoCarrinho=listaDeProdutos.indexOf(produtoA);
			double quantidadeAtual=QuantidadeDeProdutos.get(localNoCarrinho);
			if((quantidadeAtual+novaQuantidade)>produtoParaComparacao.getQuantidade()){
				
				throw new QuantidadeInsuficienteException();
			}
			QuantidadeDeProdutos.set(localNoCarrinho, quantidadeAtual+novaQuantidade);
			return;
		}

	}
    
    public double retornarQuantidadeProduto(String nomeProduto){
    	
    	for(Produto produto : listaDeProdutos){
    		if(produto.getNome().equals(nomeProduto)){
    			return QuantidadeDeProdutos.get(listaDeProdutos.indexOf(produto));
    		}
    	}
    	return 0.0;
    }
}