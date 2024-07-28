package Modelo.DAO;

import Modelo.Entidades.Medico;

import java.util.List;

public interface MedicoDAO {
    void insert(Medico doctor);
    void update(String phoneNumber1, String phoneNumber2, String email, String status,
                Integer idDoctor);
    void update(String phoneNumber2, String email, Integer idDoctor);
    void update(String email,Integer idDoctor);
    Medico findByID(Integer idDoctor);
    List<Medico> findBySpecialty(String specialty);
    List<Medico> findAll();
    List<String> findAllSpecialty();
    void disable(Medico doctor);
}
