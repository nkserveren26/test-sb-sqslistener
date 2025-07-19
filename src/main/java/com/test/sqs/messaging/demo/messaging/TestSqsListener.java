package com.test.sqs.messaging.demo.messaging;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class TestSqsListener {

    public TestSqsListener () {
        System.out.println("TestSqsListener インスタンスを生成");
    }

    @SqsListener(value = "test-queue-spring-boot")
    public void receiveMessageFromQueue (String message) {
        System.out.println("SQSからメッセージをポーリングします");
        System.out.println("Received a message from SQS: "+ message);
    }
}
