package cl.coopeuch.api.prueba.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.coopeuch.api.prueba.entity.Tarea;
import cl.coopeuch.api.prueba.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/tarea")
@Tag(name ="api- Mantenedor N1", description="API que permite crear, listar, editar y eliminar Tareas")
public class TareaController {

	@Autowired
	private TareaService tareaService;

	@GetMapping("/listarTareas")
	@Operation(description = "Devuelve todas las tareas existentes")
	@ResponseStatus(HttpStatus.OK)
	public List<Tarea> listarTareas() {
		return tareaService.findAllTareas().stream().map(tarea -> {
			return tarea;
		}).collect(Collectors.toList());
	}

	@PostMapping("/agregarTarea")
	@Operation(description = "Permite agregar una nueva tarea")
	@ResponseStatus(HttpStatus.CREATED)
	public Tarea agregarTarea(@RequestBody(required = true) Tarea tarea) {
		return tareaService.saveTarea(tarea);
	}

	@DeleteMapping("/eliminarTarea/{id}")
	@Operation(description = "Permite eliminar una tarea")
	@ResponseStatus(HttpStatus.OK)
	public void eliminarTarea(@PathVariable Long id) {
		tareaService.deleteTareaById(id);
	}

	@PutMapping("/editarTarea/{id}")
	@Operation(description = "Permite editar una tarea los campos identificador y vigente, ejemplo => {\r\n"
			+ "  \"identificador\": 2,\r\n"
			+ "  \"vigente\": true\r\n"
			+ "}")
	@ResponseStatus(HttpStatus.OK)
	public Tarea editarTarea(@RequestBody(required = true) Tarea tarea, @PathVariable(required = true) Long id) {
		tareaService.updateTarea(tarea.getDescripcion(), tarea.getVigente(), id);		
		Tarea tareaDB = tareaService.findTareaById(id);
		return tareaDB;
	}

}
