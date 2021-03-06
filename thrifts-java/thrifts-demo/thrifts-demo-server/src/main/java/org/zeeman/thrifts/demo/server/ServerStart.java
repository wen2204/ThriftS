package org.zeeman.thrifts.demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeeman.thrifts.demo.contract.EmployeeService;
import org.zeeman.thrifts.service.ThriftSServer;

public class ServerStart {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerStart.class);

    public static void main(String[] args) {
        try {
            ThriftSServer server = new ThriftSServer();
            //server.setHandlerSerializer();
            server.registerService(EmployeeService.class, EmployeeServiceImpl.class);
            server.start(80, 8384, 5, 20, 120);

            LOGGER.info("service started");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
