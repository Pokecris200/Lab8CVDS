package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   
   @Inject
   private ClienteDAO clienteDAO;
   
   @Inject
   private TipoItemDAO tipoItemDAO;
   
   @Inject
   private ItemRentadoDAO irDAO;

   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       //throw new UnsupportedOperationException("Not supported yet.");
	   return irDAO.valorMultaRetraso(itemId);
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   try {
           return clienteDAO.load(docu);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el cliente " + docu,ex);
       }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   return irDAO.loadItemClientes(idcliente);
	   
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
       
       try {
           return clienteDAO.load();
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("No se encontraron clientes");
       }
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() {
       //throw new UnsupportedOperationException("Not supported yet.");
	   return itemDAO.consultarItemsDisponibles();
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   return irDAO.consultarMultaRetraso(iditem, fechaDevolucion);
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   return tipoItemDAO.load(id);
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   return tipoItemDAO.load();
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   clienteDAO.save(date, docu, item, numdias);
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   clienteDAO.save(c);
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   return itemDAO.consultarCostoAlquiler(iditem, numdias);
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet.");
	   itemDAO.updateTarifa(id, tarifa);
   }
   
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	   itemDAO.save(i);
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	   clienteDAO.updateVeto(docu, estado);
       
   }
}
