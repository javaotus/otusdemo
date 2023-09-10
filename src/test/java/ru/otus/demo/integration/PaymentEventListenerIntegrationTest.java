package ru.otus.demo.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import ru.otus.demo.dtos.ItemDto;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class PaymentEventListenerIntegrationTest implements RabbitTestContainer {

    @Value("${otus.rabbitmq.queue}")
    private String QUEUE;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void onPaymentEvent_test(CapturedOutput output) {

        ItemDto one = ItemDto.builder()
            .id(UUID.randomUUID())
            .name("item")
            .available(new Random().nextBoolean())
            .added(LocalDate.now())
        .build();

        rabbitTemplate.convertAndSend(QUEUE, one);

        await().atMost(Duration.ofSeconds(5)).until(itemExists(output), is(true));

        assertTrue(output.getOut().contains("item"));
    }

    private Callable<Boolean> itemExists(CapturedOutput output) {
        return () -> output.getOut().contains("item");
    }

}