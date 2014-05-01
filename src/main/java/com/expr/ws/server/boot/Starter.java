package com.expr.ws.server.boot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("expr_ws_config.xml");
        logger.info("===============================================================");
        logger.info("==================== Jax WS App Started ========================");
        logger.info("===============================================================");
    }

}
