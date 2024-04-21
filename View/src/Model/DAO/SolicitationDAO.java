package Model.DAO;

import java.util.List;

import Model.Entities.Doctor;
import Model.Entities.Solicitation;

public interface SolicitationDAO {
    void insert(Solicitation solicitation);
    Solicitation findById(Integer id);
    List<Solicitation> findAll();

    interface DoctorDAO {
        void insert(Doctor doctor);
        void update(String phoneNumber1, String phoneNumber2, String address, String email,
                    Integer idDoctor);
        void update(String phoneNumber1, String address, String email,
                    Integer idDoctor);
        Doctor findByID(Integer idDoctor);
        List<Doctor> findAll();
        void disable(Integer idDoctor);
    }
}
