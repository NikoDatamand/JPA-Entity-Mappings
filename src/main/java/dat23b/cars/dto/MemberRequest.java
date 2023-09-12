package dat23b.cars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat23b.cars.entity.Member;
import dat23b.cars.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberRequest {
    String username;
    String email;
    String password;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;
    boolean approved;
    int ranking;

    public static Member createMemberEntity(MemberRequest m){
    return new Member(m.getUsername(), m.getPassword(), m.getEmail(), m.getFirstName(), m.getLastName(), m.getStreet(), m.getCity(), m.getZip());
    }

}

