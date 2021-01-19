//proxy class for ...wsdl.User

package com.example.userservice.model;
import lombok.Data;

@Data
public class User {

    private String name;
    private String lastname;
    private String phone;
    private String address;

    public User(com.example.userservice.wsdl.User user) {

        this.name = user.getName();
        this.lastname = user.getLastname();
        this.phone = user.getPhone();
        this.address = user.getAddress();

    }
}
