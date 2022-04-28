package model;

import lombok.Data;

@Data
public class Transaction {
    private String marketCode;
    private String status;
    private int amountSize;
    private String strategy;
    private String authorization;
    private String email;
    private String password;
    private String captcha;

}
