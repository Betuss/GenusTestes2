package exception;

public class ProdutosDiferentesException extends RuntimeException {

		public ProdutosDiferentesException(){}
		
		
		public ProdutosDiferentesException(String message)
		{
			super(message);
		}
}
