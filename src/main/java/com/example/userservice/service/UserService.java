package com.example.userservice.service;

import com.example.userservice.model.ServiceResponse;
import com.example.userservice.wsdl.GetByLastnameResponse;
;
import com.example.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private SoapClient1C soapClient1C;

    public ResponseEntity<List<User>> getUserListByLastname(String lastname){

        GetByLastnameResponse response = soapClient1C.getByLastname(lastname);

        List<com.example.userservice.wsdl.User> userList = response.getReturn().getUsers();

        List<User> userListProxy = userList.stream().map((user -> {return new User(user);})).collect(Collectors.toList());

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setUsers(userListProxy);

        return new ResponseEntity(serviceResponse, HttpStatus.OK);

    }

}
