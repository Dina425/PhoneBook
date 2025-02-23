package models;//package models;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder

public class Contacts {
    private String name;
    private String lastname;
    private String phoneNumber;
    private String email;
    private  String address;
    private String description;

//    public Contacts setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public Contacts setLastname(String lastname) {
//        this.lastname = lastname;
//        return this;
//    }
//
//    public Contacts setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//        return this;
//    }
//
//    public Contacts setEmail(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public Contacts setAddress(String address) {
//        this.address = address;
//        return this;
//    }
//
//    public Contacts setDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getDescription() {
//        return description;
//    }
}
