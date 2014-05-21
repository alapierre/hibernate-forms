/*
 * Copyright 2014-05-19 the original author or authors.
 */

package pl.com.softproject.altkom.hibernate.dao.hibernate;

import pl.com.softproject.altkom.hibernate.model.Team;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public interface TeamDAO {

    Team load(Long id);

    void save(Team team);
    
}
