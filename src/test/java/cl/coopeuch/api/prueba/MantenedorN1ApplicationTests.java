package cl.coopeuch.api.prueba;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.coopeuch.api.prueba.entity.Tarea;
import cl.coopeuch.api.prueba.service.TareaService;

@RunWith(SpringRunner.class)
@SpringBootTest
class MantenedorN1ApplicationTests {
	
	@Autowired
	TareaService tareaSerice;

	//@Test
	void contextLoads() {
	}
	
	// @Test
	public void agregarTareaTest() {
		Tarea tarea = new Tarea();
		tarea.setDescripcion("tarea 1 creada desde el test");
		tarea.setVigente(true);
		
		tareaSerice.saveTarea(tarea);
	}
	
	//@Test
	public void findTareaByIdTest() {
		
		Tarea tarea = tareaSerice.findTareaById(4L);		
		assertEquals(4L, tarea.getIdentificador().longValue());
		
		System.out.println("Tarea obtenida: "+tarea.toString());
		
	}
	
	@Test
	public void findAllTareaTest() {
		
		List<Tarea> tareas= tareaSerice.findAllTareas();				
		System.out.println("Listado de tareas - cantidad: "+tareas.size()+" - Listado => "+tareas.toString());
		
	}
	
	//@Test
	public void editaTareaTest() {		
		Long id = 5L;
		Tarea tarea = tareaSerice.findTareaById(id);
		System.out.println("Tarea antes del update :"+ tarea.toString());
		
		tareaSerice.updateTarea("Nueva descripcion desde test", false, id);
		
		Tarea tarea2 = tareaSerice.findTareaById(id);
		System.out.println("Tarea despues del update :"+ tarea2.toString());			
	}
	
	
	//@Test
	public void eliminarTareaByIdTest() {
		Long id = 6L;
		tareaSerice.deleteTareaById(id);		
		Tarea tarea = tareaSerice.findTareaById(id);
		
		assertNull(tarea);
	}
	

}
