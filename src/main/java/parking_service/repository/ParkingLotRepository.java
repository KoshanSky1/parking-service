package parking_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parking_service.model.ParkingLot;
import parking_service.model.User;

import java.util.List;
import java.util.Optional;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    List<ParkingLot> findAllByAuthor(User currentUser);

    Optional<ParkingLot> getByIdAndAuthor(long id, User currentUser);
}
