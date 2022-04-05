package cl.coopeuch.api.prueba.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarea")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea implements Serializable {

	private static final long serialVersionUID = -3821522356494475297L;
	
	@Id
	@Column(name ="identificador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	
	@Column(name ="descripcion")
	private String descripcion;
	
	@Column(name ="fechaCreacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name ="vigente")
	private Boolean vigente;
	

}
