package alessia.Compito.settimanale.Gestione.dispositivi.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String type;
    private String status;

    @ManyToOne
    private Employee employee;


    public Device(String type, String status) {
        this.type = type;
        this.status = status;
    }
}
