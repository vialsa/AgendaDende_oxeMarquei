/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.ConsultaDAOJDBC;
import Modelo.Entidades.Consulta;
import java.util.List;

/**
 *
 * @author LAB118-PC01
 */
public class QueryController {
    public List<Consulta> buscarConsultas(){
        ConsultaDAOJDBC consultaDAOJDBC = new ConsultaDAOJDBC();
        List<Consulta> listaConsulta = consultaDAOJDBC.findAll();
        return listaConsulta;
    }
    
    public boolean marcarConsulta(Consulta consulta) {
        try {
            ConsultaDAOJDBC consultaDAOJDBC = new ConsultaDAOJDBC();
            consultaDAOJDBC.insert(consulta);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
