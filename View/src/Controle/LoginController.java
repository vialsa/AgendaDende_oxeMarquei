/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.DAO.impl.AgentePublicoDAOJDBC;
import Modelo.Entidades.AgentePublico;

/**
 *
 * @author lucas
 */
public class LoginController {
    public AgentePublico realizaLogin(String login, String senha) {
        
        if(!login.equals("") && !senha.equals("")) {
            
            AgentePublicoDAOJDBC publicAgentDao= new AgentePublicoDAOJDBC();
            AgentePublico agent = publicAgentDao.containsUser(login, senha);
            
            if(agent != null){
                return agent;
            }
        }
        return null;
    }
}