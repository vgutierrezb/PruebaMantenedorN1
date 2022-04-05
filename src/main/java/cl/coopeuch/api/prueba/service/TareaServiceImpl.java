package cl.coopeuch.api.prueba.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.coopeuch.api.prueba.dao.TareaDao;
import cl.coopeuch.api.prueba.entity.Tarea;

@Service("tareaService")
public class TareaServiceImpl implements TareaService {

	@Autowired
	private TareaDao tareaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tarea> findAllTareas() {
		return (List<Tarea>) tareaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tarea findTareaById(Long id) {
		return tareaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Tarea saveTarea(Tarea tarea) {
		tarea.setFechaCreacion(new Date());
		return tareaDao.save(tarea);
	}

	@Override
	@Transactional
	public void deleteTareaById(Long id) {
		tareaDao.deleteById(id);
	}

	@Override
	public void updateTarea(String descripcion, Boolean vigente, Long identificador) {
		tareaDao.updateTarea(descripcion, vigente, identificador);
	}

}
