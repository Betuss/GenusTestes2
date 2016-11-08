package exception;

public class CategoriaInexistenteException extends RuntimeException {

		public CategoriaInexistenteException(){}
		
		
		public CategoriaInexistenteException(String message)
		{
			super(message);
		}
}
