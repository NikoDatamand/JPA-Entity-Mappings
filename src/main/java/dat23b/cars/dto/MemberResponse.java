package dat23b.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat23b.cars.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {
    String username;
    String email;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;
    int ranking;
    boolean approved;
    List<ReservationResponse> reservations;


    //Convert Member Entity to Member DTO
    public MemberResponse(Member m, boolean includeAll) {
        this.username = m.getUsername();
        this.email = m.getEmail();
        this.street = m.getStreet();
        this.firstName =m.getFirstName();
        this.lastName = m.getLastName();
        this.city = m.getCity();
        this.zip = m.getZip();
        if(includeAll){
            this.created = m.getCreated();
            this.edited = m.getEdited();
            this.approved = m.isApproved();
            this.ranking = m.getRanking();
        } if(m.getReservations()!=null && !m.getReservations().isEmpty()){
            this.reservations = m.getReservations().stream().map((r)-> new ReservationResponse(r)).toList();
        }
    }
}
