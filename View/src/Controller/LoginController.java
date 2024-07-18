/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.impl.PublicAgentDAOJDBC;
import Model.Entities.PublicAgent;

/**
 *
 * @author lucas
 */
public class LoginController {
    public PublicAgent realizaLogin(String login, String senha) {
        
        if(!login.equals("") && !senha.equals("")) {
            
            PublicAgentDAOJDBC publicAgentDao= new PublicAgentDAOJDBC();
            PublicAgent agent = publicAgentDao.containsUser(login, senha);
            
            if(agent != null){
                return agent;
            }
        }
        return null;
    }
}