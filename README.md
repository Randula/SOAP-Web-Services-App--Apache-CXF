##########################################################################
####################    JAX WS Sample Application    #####################
##########################################################################


Technologies Used
=================

1) Apache CXF (2.1 +)
2) Spring Framework (3.0 +)
3) Java Service Wrapper (For Server)
4) Loggers - log4j-slf4j
5) Build - Maven (2.x + compatible)


Installing & Running
====================

Running Server
--------------
1) Build app from home directory
Run - mvn clean install

2) Run app
Unzip - unzip /target/jax-ws-app.zip
Go to - /jax-ws-app/bin
Run   - ./startServer console


3) Verify
Access URL to
http://127.0.0.1:65024/exprws?wsdl


Running Client
--------------
Run the main method of - com.expr.ws.client.ExprWsClient
