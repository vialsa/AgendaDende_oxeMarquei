/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.impl.PublicAgentDAOJDBC;
import java.util.List;

/**
 *
 * @author LAB118-PC01
 */
public class PublicAgentController {
        public List buscarUsuarios(){
            PublicAgentDAOJDBC publicAgentDAOJDBC = new PublicAgentDAOJDBC();
            List listaUsuario = publicAgentDAOJDBC.findAll();
            return listaUsuario;
    }
    
}
