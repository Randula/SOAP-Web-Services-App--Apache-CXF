
package com.expr.ws.client;

import com.expr.ws.server.controller.ClientTransaction;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class ExprWsClient extends AbstractSecureWsHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExprWsClient.class);

    public static void main(String[] args) throws Exception {

        // Creating URL from WSDL
        URL url = new URL("http://127.0.0.1:65024/exprws?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://impl.controller.server.ws.expr.com/", "ClientTransactionImplService");

        // Creating Service
        Service service = Service.create(url, qname);

        ClientTransaction clientTransaction = service.getPort(ClientTransaction.class);
        Client client = ClientProxy.getClient(clientTransaction);
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        // Configure secure services for HTTPS
        configureSecureTransaction(clientTransaction);

        // Request for Order Details
        String orderDetails = clientTransaction.getOrderDetails("456123");
        logger.debug("Result : [{}]", orderDetails);

    }


}
