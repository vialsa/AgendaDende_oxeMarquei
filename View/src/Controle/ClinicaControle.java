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
        try {
            ClinicaDAOJDBC clinicaDAOJDBC = new ClinicaDAOJDBC();
            Clinica clinica = clinicaDAOJDBC.findByID(idClinica);

            return clinica;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
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
    
    public void atualizarClinica(String nameOfClinic, String address, String phoneNumber, String email, Integer idClinic){
    
        try {
            ClinicaDAOJDBC clinicaDAOJDBC = new ClinicaDAOJDBC();
            clinicaDAOJDBC.update(nameOfClinic, address, phoneNumber, email, idClinic);
        } catch (Exception e) {
            
        }
    }
}
