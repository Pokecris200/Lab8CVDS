package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoMapper {
	
	public ItemRentado consultarItemRentado(int id);
	
	public List<ItemRentado> loadItemClientes(long idcliente);
	
	public long valueMultx(Item it);

}
