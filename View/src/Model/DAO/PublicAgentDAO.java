package Model.DAO;

import Model.Entities.PublicAgent;

import java.util.List;

public interface PublicAgentDAO {
    void insert(PublicAgent publicAgent);
    void update(String phoneNumber1, String address, String email, Integer idPublicAgent);
    PublicAgent findById(Integer idPublicAgent);
    List<PublicAgent> findAll();
    void disable(Integer idPublicAgent);
}
