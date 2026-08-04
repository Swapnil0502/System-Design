package Splitwise.entity;

import java.sql.Timestamp;

public class balance {
    int id;
    int paidBy;
    int borrowerId;
    double outstanding;
    Timestamp createdAt;
}
