package edu.eci.cvds.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

public interface ClienteDAO {

    public void save(Date date, long docu, Item item, int numdias) throws PersistenceException;
    
    public void save(Cliente c) throws PersistenceException;

    public Cliente load(long id) throws PersistenceException;
    
    public List<Cliente> load() throws PersistenceException;
    
    public void updateVeto(long docu, boolean estado);
}
