package Model.DAO;

import Model.Entities.Clinic;
import java.util.List;

public interface ClinicDAO {
    void insert(Clinic clinic);
    void update(String nameOfClinic, String address, String phoneNumber, String email, Integer idClinic);
    void update(String address, String phoneNumber, String email, Integer idClinic);
    void update(String phoneNumber, String email, Integer idClinic);
    void update(String email, Integer idClinic);
    Clinic findByID(Integer idClinic);
    List<Clinic> findAll();
    void disable(Clinic clinic);
}
