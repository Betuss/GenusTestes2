/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NovasFuncionalidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.CategoriaInexistenteException;
import exception.FuncionarioNaoTrabalhaDiaException;
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
	
	public FuncionarioModificado retornarFuncionarioPorID(int idFunc){
		
		throw new UnsupportedOperationException();
		
		
	}
	
	public Faltas retornarFaltaPorID(int idFalta){
		
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
		Date dataFimlote=new Date();
		double quantidadeAtual;
		for(int i=0;i<listaLotes.size();i++){
			dataFimlote=listaLotes.get(i).getDataFimLote();
			if(dataFimlote.before(dataAtual)){
				quantidadeAtual=listaLotes.get(i).getQuantidadeAtual();
				listaLotes.get(i).setQuantidadeAtual(0);
				listaLotes.get(i).setQuantidadeDesperdicada(quantidadeAtual);
			}
		}
				
	}
	
	public int CalcularDiasTrabalhoNoMes(int ano, int mes, FuncionarioModificado func){
		
		String diasTrabalho=func.getDiasTrabalho();
		String[] parts = diasTrabalho.split("-");
		
		int totalDias=0;
		
		int quantosDiasTemOMes=0;
		
		int diaSemana;
		
		if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
			quantosDiasTemOMes=31;
		}
		
		if(mes==4||mes==6||mes==9||mes==11){
			quantosDiasTemOMes=31;
		}
		if(mes==2){
			if(ano % 400 == 0){
				quantosDiasTemOMes=29;

	        } else if((ano % 4 == 0) && (ano % 100 != 0)){
				quantosDiasTemOMes=29;

	        } else{
				quantosDiasTemOMes=28;
	        }
		}
		
		
		for(int i=0;i<quantosDiasTemOMes;i++){
			for(int k=0;k<parts.length;k++){
				
				Date dataFalsa=new Date(ano,mes,i);
				diaSemana=dataFalsa.getDay();
				String diaFuncionario=parts[k];
				
				if(diaSemana==0&&diaFuncionario.equalsIgnoreCase("DO")){
					totalDias++;
				}
				if(diaSemana==1 && diaFuncionario.equalsIgnoreCase("SG")){
					totalDias++;
				}
				if(diaSemana==2 && diaFuncionario.equalsIgnoreCase("TE")){
					totalDias++;
				}
				if(diaSemana==3 && diaFuncionario.equalsIgnoreCase("QA")){
					totalDias++;
				}
				if(diaSemana==4 && diaFuncionario.equalsIgnoreCase("QI")){
					totalDias++;
				}
				if(diaSemana==5 && diaFuncionario.equalsIgnoreCase("SE")){
					totalDias++;
				}
				if(diaSemana==6 && diaFuncionario.equalsIgnoreCase("SA")){
					totalDias++;
				}
				  
			}
		}
		return totalDias;
	}


	public int CalcularDiasTrabalhoNoMesComFalta(int ano, int mes, FuncionarioModificado func,
		List<Faltas> listaFaltas) {
		int diasFaltados=0;
		List<Faltas> listaFiltrada=new ArrayList<Faltas>();
		for(int i=0;i<listaFaltas.size();i++){
			if(listaFaltas.get(i).getDataFalta().getYear()==ano&& listaFaltas.get(i).getDataFalta().getMonth()==mes){
				Faltas faltaParaFiltrar=listaFaltas.get(i);
				listaFiltrada.add(new Faltas(faltaParaFiltrar));
				diasFaltados++;
			}
		}
		
		for(int i=0;i<listaFiltrada.size();i++){
			
		}
		
		
		String diasTrabalho=func.getDiasTrabalho();
		String[] parts = diasTrabalho.split("-");
		
		int totalDias=0;
		
		int quantosDiasTemOMes=0;
		
		int diaSemana;
		
		if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
			quantosDiasTemOMes=31;
		}
		
		if(mes==4||mes==6||mes==9||mes==11){
			quantosDiasTemOMes=31;
		}
		if(mes==2){
			if(ano % 400 == 0){
				quantosDiasTemOMes=29;

	        } else if((ano % 4 == 0) && (ano % 100 != 0)){
				quantosDiasTemOMes=29;

	        } else{
				quantosDiasTemOMes=28;
	        }
		}
		
		for(int i=0;i<quantosDiasTemOMes;i++){
			for(int k=0;k<parts.length;k++){
				
				Date dataFalsa=new Date(ano,mes,i);
				diaSemana=dataFalsa.getDay();
				String diaFuncionario=parts[k];
				if(diaSemana==0&&diaFuncionario.equalsIgnoreCase("DO")){
					totalDias++;
				}
				if(diaSemana==1 && diaFuncionario.equalsIgnoreCase("SG")){
					totalDias++;
				}
				if(diaSemana==2 && diaFuncionario.equalsIgnoreCase("TE")){
					totalDias++;
				}
				if(diaSemana==3 && diaFuncionario.equalsIgnoreCase("QA")){
					totalDias++;
				}
				if(diaSemana==4 && diaFuncionario.equalsIgnoreCase("QI")){
					totalDias++;
				}
				if(diaSemana==5 && diaFuncionario.equalsIgnoreCase("SE")){
					totalDias++;
				}
				if(diaSemana==6 && diaFuncionario.equalsIgnoreCase("SA")){
					totalDias++;
				}
				  
			}
		}
		return totalDias-diasFaltados;
		
		// TODO Auto-generated method stub
	}
	public void adicionarFalta(List<Faltas> listaDeFaltas, FuncionarioModificado Func,Date diaAtual){
		String diaSemanda;
		String dia="";
		boolean achou=false;
		
		
		 String input_date=diaAtual.getDate()+"/"+diaAtual.getMonth()+"/"+diaAtual.getYear();
		 
		  SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		  Date dt1 = null;
		try {
			dt1 = format1.parse(input_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  DateFormat format2=new SimpleDateFormat("EEEE"); 
		  String finalDay=format2.format(dt1);
		  diaSemanda=finalDay;
		  
		
		String diasTrabalho=Func.getDiasTrabalho();
		String[] parts = diasTrabalho.split("-");
		
		for(int i=0;i<parts.length;i++){
			dia="";
			
			if(parts[i].equalsIgnoreCase("DO")){
				dia="Domingo";
			}
			if(parts[i].equalsIgnoreCase("SG")){
				dia="Segunda-Feira";
			}
			if(parts[i].equalsIgnoreCase("TE")){
				dia="Terça-Feira";
			}
			if(parts[i].equalsIgnoreCase("QA")){
				dia="Quarta-Feira";
			}
			if(parts[i].equalsIgnoreCase("QI")){
				dia="Quinta-Feira";
			}
			if(parts[i].equalsIgnoreCase("SE")){
				dia="Sexta-Feira";
			}
			if(parts[i].equalsIgnoreCase("SA")){
				dia="Sábado";
			}
			
			if(dia.equalsIgnoreCase(diaSemanda)){
				achou=true;
			}
		}
		
		if(achou==true){

			int idfalta=listaDeFaltas.size()+1;
			Faltas novaFalta=new Faltas(idfalta, Func.getIdFunc(), diaAtual);
			listaDeFaltas.add(novaFalta);
			
		}else{
			throw new FuncionarioNaoTrabalhaDiaException();
		}
		
	}
	
}
