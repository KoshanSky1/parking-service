package parking_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import parking_service.dto.parking.NewParkingDto;
import parking_service.dto.parking.ParkingDtoOut;
import parking_service.model.User;
import parking_service.service.ParkingLotService;
import parking_service.service.SecurityService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("parking-lots")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;
    private final SecurityService securityService;

    @GetMapping
    public String getAllParkingLots(Model model) {
        log.info("---START GET ALL PARKING LOTS ENDPOINT---");
        User currentUser = securityService.getCurrentUser();
        List<ParkingDtoOut> allByCurrentUser = parkingLotService.getAllParkingLotsByCurrentUser(currentUser);
        model.addAttribute("allParkingLots", allByCurrentUser);
        return "parking-lots";
    }

    @PostMapping
    public String createParkingLot(NewParkingDto dto, Model model) {
        log.info("---START CREATE PARKING LOT ENDPOINT---");
        User currentUser = securityService.getCurrentUser();
        parkingLotService.createParkingLot(dto, currentUser);
        List<ParkingDtoOut> allByCurrentUser = parkingLotService.getAllParkingLotsByCurrentUser(currentUser);
        model.addAttribute("allParkingLots", allByCurrentUser);
        return "parking-lots";
    }

    @PostMapping("/delete")
    public String deleteParking(@RequestParam("lotId") long id, Model model) {
        log.info("---START DELETE PARKING LOT ENDPOINT---");
        parkingLotService.deleteParkingLot(id);
        User currentUser = securityService.getCurrentUser();
        List<ParkingDtoOut> allByCurrentUser = parkingLotService.getAllParkingLotsByCurrentUser(currentUser);
        model.addAttribute("allParkingLots", allByCurrentUser);
        return "parking-lots";
    }

}
