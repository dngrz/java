package com.csp.uploadfile.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.RPC , use=Use.ENCODED) 
public class UploadFileEndpoint {

	public int subirArchivo(String archivo) {
		System.out.println("invocado");
		return 0;
	}


}
