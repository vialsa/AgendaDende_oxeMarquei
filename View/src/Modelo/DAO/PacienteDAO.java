package Modelo.DAO;

import Modelo.Entidades.Paciente;

import java.util.List;

public interface PacienteDAO {
    void insert(Paciente patient);
    void update(String phoneNumber1, String phoneNumber2, String address, String email, Integer idPatient);
    Paciente findById(Integer idPatient);
    List<Paciente> findAll();
}
