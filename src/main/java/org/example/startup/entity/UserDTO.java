package org.example.startup.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String email;
    private String password;
    private String password2;
    private String name;
    private String nick;
    private int weight;
    private CarDTO car;
    private RolDTO rol;
    private AddressDTO address;
    private int idCar;
    private int idRol;
    private int idAddress;

}