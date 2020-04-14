package org.example.grpc.greet.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.greet.GreetRequest;
import org.example.greet.GreetResponse;
import org.example.greet.GreetServiceGrpc;
import org.example.greet.Greeting;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello gRPC Client");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);
        Greeting greeting = Greeting.newBuilder().setFirstName("John").setLastName("Smith").build();
        GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();
        GreetResponse greetResponse = greetClient.greet(greetRequest);
        System.out.println("The Response is : " + greetResponse.getResult());
        channel.shutdown();
    }

}
