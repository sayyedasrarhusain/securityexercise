package com.example.securityexercise.model;

import com.example.securityexercise.model.enums.ActionType;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Event {
    private ActionType action;
    private Sender sender;
    private Repository repository;
    private Organization organization;
}
