package cl.coopeuch.api.prueba.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import cl.coopeuch.api.prueba.entity.Tarea;

public interface TareaDao extends CrudRepository<Tarea, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Tarea t SET t.descripcion = ?1, t.vigente = ?2 WHERE t.identificador = ?3")
	public void updateTarea(String descripcion, Boolean vigente, Long identificador); 

}
