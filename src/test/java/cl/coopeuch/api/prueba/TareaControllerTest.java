package cl.coopeuch.api.prueba;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.coopeuch.api.prueba.controllers.TareaController;
import cl.coopeuch.api.prueba.entity.Tarea;
import cl.coopeuch.api.prueba.service.TareaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TareaControllerTest {

	@Autowired
	TareaController tareaController;

	@Autowired
	TareaService tareaSerice;

	// @Test
	public void agregarTaresCtrlTest() {
		Tarea tarea = new Tarea();
		tarea.setDescripcion("tarea 1 creada desde el test");
		tarea.setVigente(true);

		tarea = tareaController.agregarTarea(tarea);
		System.out.println("tarea agregada => " + tarea.toString());
	}

	@Test
	public void findAllTareaTest() {

		List<Tarea> tareas = tareaController.listarTareas();
		System.out.println("Listado de tareas - cantidad: " + tareas.size() + " - Listado => " + tareas.toString());

	}

	// @Test
	public void editaTareaTest() {
		Long id = 5L;
		Tarea tarea = tareaSerice.findTareaById(id);
		System.out.println("Tarea antes del update :" + tarea.toString());
		
		tarea.setDescripcion("Descripcon editada en test2");
		tarea.setVigente(false);

		tareaController.editarTarea(tarea, id);

		Tarea tarea2 = tareaSerice.findTareaById(id);
		System.out.println("Tarea despues del update :" + tarea2.toString());
	}

	// @Test
	public void eliminarTareaByIdTest() {
		Long id = 6L;
		tareaController.eliminarTarea(id);
		Tarea tarea = tareaSerice.findTareaById(id);

		assertNull(tarea);
	}

}
