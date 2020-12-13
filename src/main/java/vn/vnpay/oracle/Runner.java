//package vn.vnpay.oracle;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import vn.vnpay.oracle.config.RabbitMQConfig;
//import vn.vnpay.oracle.rabbit_mq.Receiver;
//
//import java.util.concurrent.TimeUnit;
//
//@Component
//public class Runner implements CommandLineRunner {
//
//    private final RabbitTemplate reRabbitTemplate;
//    private final Receiver receiver;
//
//    public Runner(Receiver receiver, RabbitTemplate reRabbitTemplate) {
//        this.receiver = receiver;
//        this.reRabbitTemplate = reRabbitTemplate;
//
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("sending message .....");
//        reRabbitTemplate.convertAndSend("spring-boot exchange",
//                "foo.bar.baz","Hello from rabbit");
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    }
//}
