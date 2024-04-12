package alessia.Compito.settimanale.Gestione.dispositivi.services;

import alessia.Compito.settimanale.Gestione.dispositivi.entities.Device;
import alessia.Compito.settimanale.Gestione.dispositivi.entities.Employee;
import alessia.Compito.settimanale.Gestione.dispositivi.exceptions.NotFoundException;
import alessia.Compito.settimanale.Gestione.dispositivi.payloads.PayloadDevice;
import alessia.Compito.settimanale.Gestione.dispositivi.repositories.DeviceDAO;
import alessia.Compito.settimanale.Gestione.dispositivi.repositories.EmployeeDAO;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DeviceService {

    @Autowired
    DeviceDAO deviceDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    public List<Device> getAllDevices(){
        return this.deviceDAO.findAll();
    }

    public Device saveDevice(PayloadDevice body){
       Device newDevice = new Device(body.type(), body.status());
       return this.deviceDAO.save(newDevice);
    }

    public Device findDeviceById(int id){
        return this.deviceDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public Device findByIdAndUpdate(int id, PayloadDevice body){
        Optional<Device> optionalDevice = deviceDAO.findById(id);

        if (optionalDevice.isPresent()){
            Device found = optionalDevice.get();
            found.setStatus(body.status());
            return this.deviceDAO.save(found);
        }else {
            throw new NotFoundException(id);
        }

    }

    public void findByIdAndDelete(int id){
        Optional<Device> optionalDevice = deviceDAO.findById(id);
        if (optionalDevice.isPresent()){
            Device found = optionalDevice.get();
            this.deviceDAO.delete(found);
        }else {
            throw new NotFoundException(id);
        }

    }
}
