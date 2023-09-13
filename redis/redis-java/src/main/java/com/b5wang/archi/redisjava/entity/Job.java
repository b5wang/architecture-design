package com.b5wang.archi.redisjava.entity;

import lombok.Data;

import java.time.Instant;

@Data
public class Job {

    private long id = System.currentTimeMillis();
    private int executionTime = 15;//seconds

    private Instant time = Instant.now();

}
