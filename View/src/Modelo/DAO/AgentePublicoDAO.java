package Modelo.DAO;

import Modelo.Entidades.AgentePublico;

import java.util.List;

public interface AgentePublicoDAO {
    void insert(AgentePublico publicAgent);
    void update(String phoneNumber1, String address, String email, Integer idPublicAgent);
    AgentePublico findById(Integer idPublicAgent);
    List<AgentePublico> findAll();
    AgentePublico containsUser(String user, String password);
    void disable(Integer idPublicAgent);
}
