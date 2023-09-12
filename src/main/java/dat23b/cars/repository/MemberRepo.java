package dat23b.cars.repository;

import dat23b.cars.entity.Car;
import dat23b.cars.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member,String> {
}
