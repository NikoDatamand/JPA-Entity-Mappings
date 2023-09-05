package dat23b.cars.api;

import dat23b.cars.dto.MemberRequest;
import dat23b.cars.dto.MemberResponse;
import dat23b.cars.entity.Member;
import dat23b.cars.repository.MemberRepo;
import dat23b.cars.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //Access type: all
    @GetMapping
    List<MemberResponse> getMembers(){
        return memberService.getMembers(false);
    }

    //Access type: all
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception {
        return memberService.getMemberById(username, false);
    }

    //Access type: member, admin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }

    //Access type: member, admin
    @PutMapping("/{username}")
    ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
        return null;
    }

    //Access type: admin
    @PatchMapping("/ranking/{username}/{value}")
    ResponseEntity<Boolean> setRankingForUser(@PathVariable String username, @PathVariable int value) {
        return null;
    }

    //Access type: admin
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username) {
        memberService.deleteMemberByUsername(username);
    }


}

