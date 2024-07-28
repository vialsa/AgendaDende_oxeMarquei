/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.ClinicaDAOJDBC;
import Modelo.Entidades.Clinica;
import java.util.List;
import javax.swing.DefaultListModel;
import Modelo.DAO.ClinicaDAO;

/**
 *
 * @author Discente
 */
public class ClinicaControle {
    public List<Clinica> buscarClinicas() {
        ClinicaDAOJDBC clinicDAOJDBC = new ClinicaDAOJDBC();
        List<Clinica> clinicas = clinicDAOJDBC.findAll();
        
        return clinicas;
    }
    
    public Clinica buscarClinica(int idClinica){
        ClinicaDAOJDBC clinicaDAOJDBC = new ClinicaDAOJDBC();
        Clinica clinica = clinicaDAOJDBC.findByID(idClinica);
        
        return clinica;
    }
        
    public boolean adicionarClinica(Clinica clinica) {
        try {
            ClinicaDAOJDBC clinicDAOJDBC = new ClinicaDAOJDBC();
            clinicDAOJDBC.insert(clinica);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
