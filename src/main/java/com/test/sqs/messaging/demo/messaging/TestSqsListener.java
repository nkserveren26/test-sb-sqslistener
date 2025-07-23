package com.test.sqs.messaging.demo.messaging;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode;
import org.springframework.stereotype.Component;

@Component
public class TestSqsListener {

    public TestSqsListener () {
        System.out.println("TestSqsListener インスタンスを生成");
    }

    @SqsListener(value = "test-queue-spring-boot", acknowledgementMode = SqsListenerAcknowledgementMode.ON_SUCCESS)
    public void receiveMessageFromQueue (String message) {
        try {
            System.out.println("メッセージをポーリングします");
            System.out.println("Received a message from SQS: "+ message);
            // 意図的に例外をスロー
            throw new RuntimeException("これは意図的な例外です");
        } catch (RuntimeException e) {
            System.out.println("例外が発生しました：" + e);
        }
    }
}
