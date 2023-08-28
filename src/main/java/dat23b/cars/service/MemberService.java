package dat23b.cars.service;

import dat23b.cars.dto.MemberRequest;
import dat23b.cars.dto.MemberResponse;
import dat23b.cars.entity.Member;
import dat23b.cars.repository.MemberRepo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<MemberResponse> getMembers(boolean includeAll) {
        List<Member> members = memberRepo.findAll();
        List<MemberResponse> response = new ArrayList<>();
        for (Member member : members) {
            MemberResponse mr = new MemberResponse(member, includeAll);
            response.add(mr);
        }
        return response;
    }

    public MemberResponse addMember(MemberRequest body) {
        Member newMember = MemberRequest.getMemberEntity(body);
        newMember = memberRepo.save(newMember);
        return new MemberResponse(newMember, true);
    }
}