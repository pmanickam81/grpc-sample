package org.example.grpc.greet.server;

import io.grpc.stub.StreamObserver;
import org.example.greet.*;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("Inside greet method in GreetServiceImpl");
        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();
        String result = "Hello " + firstName +" " + lastName + "!" ;
        GreetResponse response = GreetResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
