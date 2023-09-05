package dat23b.cars.service;

import dat23b.cars.dto.MemberRequest;
import dat23b.cars.dto.MemberResponse;
import dat23b.cars.entity.Member;
import dat23b.cars.repository.MemberRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MemberServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepo memberRepo;

    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        memberService = new MemberService(memberRepo);
    }

    @Test
    public void testGetMembers() {
        Member member1 = new Member("user1", "password1", "email1@example.com", "First1", "Last1", "Street1", "City1", "Zip1");
        Member member2 = new Member("user2", "password2", "email2@example.com", "First2", "Last2", "Street2", "City2", "Zip2");
        entityManager.persist(member1);
        entityManager.persist(member2);

        List<MemberResponse> response = memberService.getMembers(true);

        assertEquals(2, response.size());
    }

    @Test
    public void testGetMemberById() throws Exception {
        Member member3 = new Member("user3", "password3", "email3@example.com", "First3", "Last3", "Street3", "City3", "Zip3");
        entityManager.persist(member3);

        String username = "user1";
        MemberResponse response = memberService.getMemberById(username, true);

        assertEquals(username, response.getUsername());
    }

    @Test
    public void testAddMember() {

        Member member4 = new Member("user4", "password4", "email4@example.com", "First4", "Last4", "Street4", "City4", "Zip4");
        MemberRequest memberRequest = new MemberRequest(member4);

        MemberResponse response = memberService.addMember(memberRequest);

        assertEquals("user4", response.getUsername());
    }

    @Test
    public void testDeleteMemberByUsername() {
        Member member5 = new Member("user5", "password5", "email5@example.com", "First5", "Last5", "Street5", "City5", "Zip5");
        entityManager.persist(member5);

        String username = "user5";

        memberService.deleteMemberByUsername(username);

        assertEquals(0, memberService.memberRepo.findAll().size());
    }
}