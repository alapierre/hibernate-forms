/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.com.softproject.altkom.hibernate.model.Team;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Repository
public class TeamDAOImpl implements TeamDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Team load(long id) {
        return (Team) sessionFactory.getCurrentSession().load(Team.class, id);
    }
    
    @Override
    public void save(Team team) {
        sessionFactory.getCurrentSession().save(team);
    }
}
