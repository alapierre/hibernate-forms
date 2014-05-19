/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.com.softproject.altkom.hibernate.dao;

import org.hibernate.Session;
import pl.com.softproject.altkom.hibernate.HibernateUtil;
import pl.com.softproject.altkom.hibernate.model.Team;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class TeamDAO {
    
    private final Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
    
    public Team load(long id) {
        return (Team) currentSession.load(Team.class, id);
    }
    
    public void save(Team team) {
        currentSession.save(team);
    }
}
