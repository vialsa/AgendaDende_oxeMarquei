package Modelo.DAO;

import Modelo.Entidades.Clinica;
import java.util.List;

public interface ClinicaDAO {
    void insert(Clinica clinic);
    void update(String nameOfClinic, String address, String phoneNumber, String email, String additionalInformation, Integer idClinic);
    void update(String address, String phoneNumber, String email, Integer idClinic);
    void update(String phoneNumber, String email, Integer idClinic);
    void update(String email, Integer idClinic);
    Clinica findByID(Integer idClinic);
    List<Clinica> findAll();
    void disable(Clinica clinic);
}
