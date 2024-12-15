package parking_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parking_service.dto.parking.NewParkingDto;
import parking_service.dto.parking.ParkingDtoOut;
import parking_service.exception.EntityNotFoundException;
import parking_service.model.ParkingLot;
import parking_service.model.User;
import parking_service.repository.ParkingLotRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Transactional(readOnly = true)
    public List<ParkingDtoOut> getAllParkingLotsByCurrentUser(User currentUser) {
        log.info("A list of parking lots for user with id" + currentUser.getId() + " has been generated");
        return parkingLotRepository.findAllByAuthor(currentUser)
                .stream().map(ParkingDtoOut::of).toList();
    }

    @Transactional(readOnly = true)
    public ParkingDtoOut getParkingLotByIdAndUser(long id, User currentUser) {
        log.info("ParkingLot with id=" + id + " found");
        return ParkingDtoOut.of(parkingLotRepository.getByIdAndAuthor(id, currentUser)
                .orElseThrow(() -> new EntityNotFoundException("Parking lot with id=" + id + " was not found")));
    }

    @Transactional
    public ParkingDtoOut createParkingLot(NewParkingDto dto, User currentUser) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAddress(dto.address());
        parkingLot.setCity(dto.city());
        parkingLot.setAuthor(currentUser);
        log.info("User with id=" + currentUser.getId() + " added a new parking lot " + dto.address());
        return ParkingDtoOut.of(parkingLotRepository.save(parkingLot));
    }

    @Transactional
    public void deleteParkingLot(long id) {
        log.info("Parking lot with id=" + id + " was deleted");
        parkingLotRepository.deleteById(id);
    }

}