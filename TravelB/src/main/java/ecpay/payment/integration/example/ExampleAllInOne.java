package ecpay.payment.integration.example;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.w3c.dom.Document;

import ecpay.payment.integration.ecpayOperator.EcpayFunction;

public class ExampleAllInOne {
	public static void main(String[] args) {
		
	
	try {
		Document doc;
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String configPath = URLDecoder.decode(classLoader.getResource("./payment_conf.xml").getPath(), "UTF-8");
		doc = EcpayFunction.xmlParser(configPath);
	}catch(UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	
	
	}
}
