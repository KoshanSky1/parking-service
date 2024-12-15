package parking_service.dto.parking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parking_service.dto.user.UserDtoOut;
import parking_service.model.ParkingLot;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDtoOut {
    private Long id;
    private String city;
    private String address;
    private UserDtoOut author;

    public static ParkingDtoOut of(ParkingLot parkingLot) {
        if(parkingLot == null){
            return null;
        }

        return new ParkingDtoOut(
            parkingLot.getId(),
            parkingLot.getCity(),
            parkingLot.getAddress(),
            UserDtoOut.of(parkingLot.getAuthor())
        );
    }
}
