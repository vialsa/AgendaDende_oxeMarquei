/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.ClinicaDAOJDBC;
import java.sql.Date;
import java.time.LocalDate;

import Modelo.DAO.impl.PacienteDAOJDBC;
import Modelo.Entidades.Clinica;
import Modelo.Entidades.Paciente;
import java.util.List;


/**
 *
 * @author lucas
 */
public class PacienteControle {
    public boolean cadastroPaciente(Paciente paciente){
        try {
            PacienteDAOJDBC pacienteDAO = new PacienteDAOJDBC();
            pacienteDAO.insert(paciente);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public void atualizarPaciente (String nome, String phoneNumber1, String phoneNumber2, String address, String email, Integer idPatient) {
        try {
            PacienteDAOJDBC pacienteDAO = new PacienteDAOJDBC();
            pacienteDAO.update(nome, phoneNumber1, phoneNumber2, address, email, idPatient);
        } catch (Exception e) {
        }
    }
    
    public List buscarPacientes(){
        PacienteDAOJDBC pacienteDAO = new PacienteDAOJDBC();
        List listPatient = pacienteDAO.findAll();
        return listPatient;
    }
    
    public Paciente buscarPaciente(int idPaciente){
        try {
            PacienteDAOJDBC pacienteDAOJDBC = new PacienteDAOJDBC();
            Paciente paciente = pacienteDAOJDBC.findById(idPaciente);

            return paciente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
