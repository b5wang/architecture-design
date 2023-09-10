package com.b5wang.archi.redisjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * -----
 * Error convert string to object:
 * com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot construct instance of
 * `com.b5wang.archi.redisjava.entity.DBConfig` (although at least one Creator exists):
 * no String-argument constructor/factory method to deserialize from String value
 * ('{"url":"localhost","port":3306,"username":"root","password":"","max_connection":50,"connection_timeout":600}')
 * -----
 * https://stackoverflow.com/questions/45110371/no-string-argument-constructor-factory-method-to-deserialize-from-string-value
 * Let ObjectMapper receive empty string
 *
 * */
@Data
//@AllArgsConstructor(suppressConstructorProperties = true)
public class DBConfig {

    private String url;
    private int port;
    private String username;
    private String password;
    private int maxConnection;
    private int connectionTimeout;

}
