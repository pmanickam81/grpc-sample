package org.example.grpc.calculator.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatorServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server Started for Calculator Service");
        Server server = ServerBuilder.forPort(50052).addService(new CalculatorServiceImpl()).build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));
        server.awaitTermination();
    }

}
