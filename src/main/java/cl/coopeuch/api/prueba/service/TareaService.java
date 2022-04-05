package cl.coopeuch.api.prueba.service;

import java.util.List;

import cl.coopeuch.api.prueba.entity.Tarea;

public interface TareaService {

	public List<Tarea> findAllTareas();

	public Tarea findTareaById(Long id);

	public Tarea saveTarea(Tarea tarea);

	public void deleteTareaById(Long id);

	public void updateTarea(String descripcion, Boolean vigente, Long identificador);

}
