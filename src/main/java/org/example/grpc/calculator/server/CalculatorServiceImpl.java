package org.example.grpc.calculator.server;

import io.grpc.stub.StreamObserver;
import org.example.calculator.CalculatorServiceGrpc;
import org.example.calculator.SumRequest;
import org.example.calculator.SumResponse;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void calculateSum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        System.out.println("Inside greet method in GreetServiceImpl");
        SumResponse sumResponse = SumResponse.newBuilder()
                                        .setSumResult(request.getFirstNumber()+request.getSecondNumber())
                                        .build();
        responseObserver.onNext(sumResponse);
        responseObserver.onCompleted();
    }
}
