package com.b5wang.architect.rabbitmqconsumer.entity;

import lombok.Data;

@Data
public class AppEvent {
    private String app;
    private String event;
    private String priority;
    private String msg;
}
