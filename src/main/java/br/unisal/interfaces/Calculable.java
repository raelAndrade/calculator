package br.unisal.interfaces;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.soap.SOAPException;

import br.unisal.exceptions.DivisionByZeroArithymeticException;

import static br.unisal.util.Constants.*;

/**
 * 
 * @author jether.rodrigues
 *
 * Style.RPC: menos verboso, menos detalhes
 * Style.DOCUMENT: mais verboso, gera mais detalhes
 */

@WebService
@SOAPBinding(style = Style.DOCUMENT) 
public interface Calculable {
	/**
	 * Divide method
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 * @throws DivisionByZeroArithymeticException
	 * @throws SOAPException
	 */
	@WebMethod(action=HOST + "/divide", operationName="division")
	public double divide(
		@WebParam(name = "dividend") double dividend,
		@WebParam(name = "divisor") double divisor
	) throws DivisionByZeroArithymeticException, SOAPException;
	
	@WebMethod(action=HOST + "/soma", operationName="sum")
	public double sum(
			@WebParam(name = "portion1") double portion1,
			@WebParam(name = "portion2") double portion2
		);
	
	@WebMethod(action=HOST + "/subtrai", operationName="subtract")
	public double subtract(
			@WebParam(name = "subtract1") double subtract1,
			@WebParam(name = "subtract2") double subtract2
		);
	
	@WebMethod(action=HOST + "/multplica", operationName="mult")
	public double mult(
			@WebParam(name = "mult1") double mult1,
			@WebParam(name = "mult2") double mult2
		);

}
