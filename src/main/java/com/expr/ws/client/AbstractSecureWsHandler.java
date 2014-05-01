
package com.expr.ws.client;


import com.expr.ws.server.controller.ClientTransaction;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public abstract class AbstractSecureWsHandler {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSecureWsHandler.class);

    /**
     * Enable Services for HTTPS Requests
     * @param clientTransaction
     */
    public static void configureSecureTransaction(ClientTransaction clientTransaction) {
        Client client = ClientProxy.getClient(clientTransaction);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        String targetAddress = http.getTarget().getAddress().getValue();
        logger.info("Received Target Address [{}]", targetAddress);

        if (targetAddress.toLowerCase().startsWith("https:")) {
            logger.info("Execute TrustManager for  HTTPS");
            TrustManager[] simpleTrustManager = new TrustManager[] { new X509TrustManager() {
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            } };
            TLSClientParameters tlsParams = new TLSClientParameters();
            tlsParams.setTrustManagers(simpleTrustManager);
            tlsParams.setDisableCNCheck(true);
            http.setTlsClientParameters(tlsParams);
        }
    }

}
