/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Date;
import java.time.LocalDate;

import Model.DAO.impl.PatientDAOJDBC;
import Model.Entities.Patient;


/**
 *
 * @author lucas
 */
public class NovoPacienteController {
    public void cadastroPaciente(String nome, String CPF, String RG, LocalDate dataNascimento, 
            String tel1, String tel2, String endereco, String email, String sigtap){
        PatientDAOJDBC pacienteDAO = new PatientDAOJDBC();
        Patient novoPaciente = new Patient(
            nome, CPF, RG, tel1, tel2, dataNascimento, endereco, email, sigtap
        );
        pacienteDAO.insert(novoPaciente);
    }
    
    public void cadastroPaciente(String nome, String CPF, String RG, LocalDate dataNascimento, 
        String tel1, String endereco, String sigtap, String email){
        PatientDAOJDBC pacienteDAO = new PatientDAOJDBC();
        Patient novoPaciente = new Patient(
            nome, CPF, RG, tel1, dataNascimento, endereco, email, sigtap
        );
        pacienteDAO.insert(novoPaciente);
    }
}
