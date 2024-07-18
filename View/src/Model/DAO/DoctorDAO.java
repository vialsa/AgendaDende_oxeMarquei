package Model.DAO;

import Model.Entities.Doctor;

import java.util.List;

public interface DoctorDAO {
    void insert(Doctor doctor);
    void update(String phoneNumber1, String phoneNumber2, String address, String email, String status,
                Integer idDoctor);
    void update(String phoneNumber2, String address, String email, Integer idDoctor);
    void update(String address, String email,Integer idDoctor);
    void update(String email, Integer idDoctor);
    Doctor findByID(Integer idDoctor);
    List<Doctor> findAll();
    void disable(Doctor doctor);
}
