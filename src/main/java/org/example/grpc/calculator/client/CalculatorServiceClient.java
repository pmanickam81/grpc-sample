package org.example.grpc.calculator.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.calculator.CalculatorServiceGrpc;
import org.example.calculator.SumRequest;
import org.example.calculator.SumResponse;

public class CalculatorServiceClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext().build();
        CalculatorServiceGrpc.CalculatorServiceBlockingStub calculatorServiceClient = CalculatorServiceGrpc.newBlockingStub(channel);
        SumRequest sumRequest = SumRequest.newBuilder().setFirstNumber(3)
                .setSecondNumber(5).build();
        SumResponse sumResponse = calculatorServiceClient.calculateSum(sumRequest);
        System.out.println(sumRequest.getFirstNumber() + " + " + sumRequest.getSecondNumber() + " = " + sumResponse.getSumResult());
        channel.shutdown();
    }
}
