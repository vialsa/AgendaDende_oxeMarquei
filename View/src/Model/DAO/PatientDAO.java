package Model.DAO;

import Model.Entities.Patient;

import java.util.List;

public interface PatientDAO {
    void insert(Patient patient);
    void update(String phoneNumber1, String phoneNumber2, String address, String email, Integer idPatient);
    Patient findById(Integer idPatient);
    List<Patient> findAll();
}
