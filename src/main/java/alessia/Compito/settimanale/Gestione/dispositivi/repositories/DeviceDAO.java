package alessia.Compito.settimanale.Gestione.dispositivi.repositories;

import alessia.Compito.settimanale.Gestione.dispositivi.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDAO extends JpaRepository<Device, Integer> {
}
