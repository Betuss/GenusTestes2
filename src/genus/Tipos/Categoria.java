package genus.Tipos;

/**
 *
 * @author junior
 */
public class Categoria {
    int IDcategoria;
    String nome;
    
    public Categoria(int IDcategoria, String nome){
    	this.IDcategoria = IDcategoria;
    	this.nome = nome;
    }
    
    public int getIDcategoria(){
    	return this.IDcategoria;
    }
    
    public String getNome(){
    	return this.nome;
    }
    
    public void setIDcategoria(int novoID){
    	this.IDcategoria = novoID;
    }
    
    public void setNome(String novoNome){
    	this.nome = novoNome;
    }
    
    
    
}
