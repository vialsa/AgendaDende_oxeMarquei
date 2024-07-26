/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.impl.DoctorDAOJDBC;
import Model.Entities.Doctor;
import java.util.List;

/**
 *
 * @author lucas
 */
public class DoctorController {
    public List<Doctor> buscarMedicos() {
        DoctorDAOJDBC doctorDAOJDBC = new DoctorDAOJDBC();
        List<Doctor> medicos = doctorDAOJDBC.findAll();
        
        return medicos;
    }
    
    public List<Doctor> buscarMedidosPorEspecialidade(String especialidade) {
        DoctorDAOJDBC doctorDAOJDBC = new DoctorDAOJDBC();
        List<Doctor> medicos = doctorDAOJDBC.findBySpecialty(especialidade);
        
        return medicos;
    }
    
    public List<String> buscarEspecialidades() {
        DoctorDAOJDBC doctorDAOJDBC = new DoctorDAOJDBC();
        List<String> especialidades = doctorDAOJDBC.findAllSpecialty();
        
        return especialidades;
    }
}
