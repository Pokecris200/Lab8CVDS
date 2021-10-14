package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.List;
import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoMapper {
	
	public ItemRentado consultarItemRentado(@Param ("idIR") int id);
	
	public List<ItemRentado> loadItemClientes(@Param ("idCli") long idcliente);
	
	public int valueMultx(@Param ("item") Item it);
	
	public int consultarMultaxRetraso(@Param ("item") Item it, @Param ("dev") Date devolucion);

}
