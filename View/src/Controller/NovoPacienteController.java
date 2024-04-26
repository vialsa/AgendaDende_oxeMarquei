/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.impl.PatientDAOJDBC;
import Model.Entities.Patient;


/**
 *
 * @author lucas
 */
public class NovoPacienteController {
    public void realizaCadastroPaciente(String nome, String CPF, String dataNascimento, 
            String tel1, String tel2, String endereco, String sigtap, String email){
        PatientDAOJDBC pacienteDAO = new PatientDAOJDBC();
        Patient novoPaciente = pacienteDAO.insert(
                nome, CPF, data
        );
    }
    
    public void realizaCadastroPaciente(String nome, String CPF, String dataNascimento, 
        String tel1, String endereco, String sigtap, String email){
           
    }
}
