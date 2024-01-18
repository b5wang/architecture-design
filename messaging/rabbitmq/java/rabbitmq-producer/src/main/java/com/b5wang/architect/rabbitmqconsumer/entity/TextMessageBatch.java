package com.b5wang.architect.rabbitmqconsumer.entity;

import lombok.Data;

@Data
public class TextMessageBatch {

    private int total;

    private String msg;

}
