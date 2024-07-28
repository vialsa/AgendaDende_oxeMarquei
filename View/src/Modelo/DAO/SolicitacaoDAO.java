package Modelo.DAO;

import java.util.List;

import Modelo.Entidades.Medico;
import Modelo.Entidades.Solicitacao;

public interface SolicitacaoDAO {
    void insert(Solicitacao solicitation);
    Solicitacao findById(Integer id);
    List<Solicitacao> findAll();

    interface DoctorDAO {
        void insert(Medico doctor);
        void update(String phoneNumber1, String phoneNumber2, String address, String email,
                    Integer idDoctor);
        void update(String phoneNumber1, String address, String email,
                    Integer idDoctor);
        Medico findByID(Integer idDoctor);
        List<Medico> findAll();
        void disable(Integer idDoctor);
    }
}
