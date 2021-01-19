package com.example.userservice.model;

import lombok.Data;

import java.util.List;

@Data
public class ServiceResponse {

    private List<User> users;

}
