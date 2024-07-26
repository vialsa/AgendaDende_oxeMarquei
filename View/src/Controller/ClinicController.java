/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ClinicDAO;
import Model.DAO.impl.ClinicDAOJDBC;
import Model.Entities.Clinic;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Discente
 */
public class ClinicController {
    public List<Clinic> buscarClinicas() {
        ClinicDAOJDBC clinicDAOJDBC = new ClinicDAOJDBC();
        List<Clinic> clinicas = clinicDAOJDBC.findAll();
        
   
        return clinicas;
    }
    
    public void adicionarClinica(Clinic clinica) {
        try {
            ClinicDAOJDBC clinicDAOJDBC = new ClinicDAOJDBC();
            clinicDAOJDBC.insert(clinica);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
