package com.expr.ws.server.controller.impl;

import com.expr.ws.server.controller.ClientTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;


@WebService(endpointInterface = "com.expr.ws.server.controller.ClientTransaction")
public class ClientTransactionImpl implements ClientTransaction {

    private static final Logger logger = LoggerFactory.getLogger(ClientTransactionImpl.class);

    @Override
    public String getOrderDetails(String orderNo) {
        logger.debug("Received Order No : [{}]", orderNo);
        return "Paid Amount 25.00 LKR | Transaction Ref No - 25669321  for order No - " + orderNo;
    }

}
