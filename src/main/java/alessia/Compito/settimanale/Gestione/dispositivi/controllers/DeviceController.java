package alessia.Compito.settimanale.Gestione.dispositivi.controllers;


import alessia.Compito.settimanale.Gestione.dispositivi.entities.Device;
import alessia.Compito.settimanale.Gestione.dispositivi.payloads.PayloadDevice;
import alessia.Compito.settimanale.Gestione.dispositivi.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping
    private List<Device> getAllDevices() {
        return this.deviceService.getAllDevices();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Device saveDevice(@RequestBody PayloadDevice body) {
        return deviceService.saveDevice(body);
    }

    @GetMapping("/{deviceId}")
    public Device findSingleDevice(@PathVariable int deviceId) {
        return this.deviceService.findDeviceById(deviceId);
    }

    @PutMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Device findSingleDeviceAndUpdate(@PathVariable int deviceId, @RequestBody Device body) {
        return this.deviceService.findByIdAndUpdate(deviceId, body);
    }

    @DeleteMapping("/deviceId")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findSingleDeviceAndDelete(@PathVariable int deviceId){
        this.deviceService.findByIdAndDelete(deviceId);
    }
}
