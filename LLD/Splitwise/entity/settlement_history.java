package Splitwise.entity;

import java.sql.Timestamp;

public class settlement_history {

    int id;
    int paidBy;
    int borrowerId;
    double settled_amount;
    Timestamp settledAt;
}
