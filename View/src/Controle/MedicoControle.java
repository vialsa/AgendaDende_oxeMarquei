/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.MedicoDAOJDBC;
import Modelo.Entidades.Clinica;
import Modelo.Entidades.Medico;
import java.util.List;

/**
 *
 * @author lucas
 */
public class MedicoControle {
    public boolean cadastroMedico(Medico medico) {
        try {
            MedicoDAOJDBC medicoDAOJDBC = new MedicoDAOJDBC();
            medicoDAOJDBC.insert(medico);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Medico> buscarMedicos() {
        MedicoDAOJDBC doctorDAOJDBC = new MedicoDAOJDBC();
        List<Medico> medicos = doctorDAOJDBC.findAll();
        
        return medicos;
    }
    
    public List<Medico> buscarMedidosPorEspecialidade(String especialidade) {
        MedicoDAOJDBC doctorDAOJDBC = new MedicoDAOJDBC();
        List<Medico> medicos = doctorDAOJDBC.findBySpecialty(especialidade);
        
        return medicos;
    }
    
    public List<String> buscarEspecialidades() {
        MedicoDAOJDBC doctorDAOJDBC = new MedicoDAOJDBC();
        List<String> especialidades = doctorDAOJDBC.findAllSpecialty();
        
        return especialidades;
    }
    
    public Medico buscarMedico(int idMedico) {
        try {
            MedicoDAOJDBC medicoDAOJDBC = new MedicoDAOJDBC();
            Medico medico = medicoDAOJDBC.findByID(idMedico);

            return medico;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void atualizarMedico (Integer idMedico, String nome, int clinica, String tel1, String tel2, String email){
        try {
            MedicoDAOJDBC medico = new MedicoDAOJDBC();
            medico.update(idMedico, nome, clinica, tel1, tel2, email);
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
