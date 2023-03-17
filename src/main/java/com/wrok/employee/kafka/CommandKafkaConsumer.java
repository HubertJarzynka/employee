package com.wrok.employee.kafka;

import com.wrok.employee.entity.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Slf4j
@RequiredArgsConstructor
public class CommandKafkaConsumer {

    Logger logger = LoggerFactory.getLogger(CommandKafkaConsumer.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @KafkaListener(
            topics = "Kafka_Example",
            groupId = "myGroupId",
            containerFactory = "kafkaListenerContainerFactory")

    public void consume(ConsumerRecord<String, Employee> record) {
        String data = record.value().toString();
        log.info(record.value().toString());
        String sql = "INSERT INTO `food_docker`.`tbl_kafka` (`name`) VALUES (?)";
        jdbcTemplate.update(sql, data);

    }

}
