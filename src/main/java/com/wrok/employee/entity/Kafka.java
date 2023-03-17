package com.wrok.employee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Kafka {

    private String kafkaidmessage;

    public Kafka(String kafkaidmessage) {
        this.kafkaidmessage = kafkaidmessage;
    }
}
