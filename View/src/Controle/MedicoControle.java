/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.MedicoDAOJDBC;
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
}
