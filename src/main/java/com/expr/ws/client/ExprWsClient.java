
package com.expr.ws.client;

import com.expr.ws.server.controller.ClientTransaction;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class ExprWsClient extends AbstractSecureWsHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExprWsClient.class);
    private static final String SERVICE_URL = "http://127.0.0.1:65024/exprws";

    public static void main(String[] args) throws Exception {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ClientTransaction.class);
        factory.setAddress(SERVICE_URL);
        ClientTransaction clientTransaction = (ClientTransaction) factory.create();

        Client client = ClientProxy.getClient(clientTransaction);
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        // Configure secure services for HTTPS
        configureSecureTransaction(clientTransaction);

        // Request for Order Details
        String orderDetails = clientTransaction.getOrderDetails("445677");
        logger.debug("Result : [{}]", orderDetails);
        System.out.println("Result : " + orderDetails);

    }

}
