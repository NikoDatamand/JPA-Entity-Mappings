package dat23b.cars.repository;

import dat23b.cars.entity.Car;
import dat23b.cars.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member,Integer> {
}
