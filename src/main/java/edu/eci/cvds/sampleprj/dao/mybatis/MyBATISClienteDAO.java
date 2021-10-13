package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO{
    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public Cliente load(long id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente: "+id,e);
        }
    }

	@Override
	public List<Cliente> load() throws PersistenceException {
		// TODO Auto-generated method stub
		return clienteMapper.consultarClientes();
	}

	@Override
	public void save(Cliente c) throws PersistenceException {
		// TODO Auto-generated method stub
		clienteMapper.añadirCliente(c);
		
	}

	@Override
	public void updateVeto(long doc, boolean estado) {
		// TODO Auto-generated method stub
		Cliente c = load(doc);
		clienteMapper.actualizarVeto(c.getDocumento(), estado);
		
	}

	@Override
	public void save(Date date, long docu, Item item, int numdias) throws PersistenceException {
		// TODO Auto-generated method stub
		Date fFin = Date.valueOf(date.toLocalDate().plusDays(numdias));
		clienteMapper.agregarItemRentadoACliente(docu, item.getId(), date, fFin);
		
	}
    
}
