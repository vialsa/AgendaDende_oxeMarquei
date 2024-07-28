/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.AgentePublicoDAOJDBC;
import java.util.List;

/**
 *
 * @author LAB118-PC01
 */
public class PublicAgentController {
        public List buscarUsuarios(){
            AgentePublicoDAOJDBC publicAgentDAOJDBC = new AgentePublicoDAOJDBC();
            List listaUsuario = publicAgentDAOJDBC.findAll();
            return listaUsuario;
    }
    
}
