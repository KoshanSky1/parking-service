package parking_service.dto.parking;

import lombok.Builder;

@Builder
public record NewParkingDto (
        String city,
        String address
) {
}