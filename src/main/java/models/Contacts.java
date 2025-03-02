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

}
