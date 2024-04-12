package alessia.Compito.settimanale.Gestione.dispositivi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String username;
    private String name;
    private String surname;
    private String eMail;
    private String avatarUrl;

    @OneToMany
    private List<Device> devicesList = new ArrayList<>();

    public Employee(String username, String name, String surname, String eMail, String avatarUrl, List<Device> devicesList) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.avatarUrl = avatarUrl;
        this.devicesList = devicesList;
    }
}
