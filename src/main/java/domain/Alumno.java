package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Alumno implements BaseEntity<Long> {
	@Id
	@SequenceGenerator(name = "Alumno_ID_GENERATOR", sequenceName = "Alumno_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alumno_ID_GENERATOR")
	private Long ID_alumno;

	private String nombres;
	
	private String apellidoPaterno;

	private String apellidoMaterno;
	
	private String dni;
	
	@OneToMany(mappedBy = "alumno")
	private List<Matricula> cursos;

	@Override
	public Long getId() {
		return ID_alumno;
	}

	@Override
	public void setId(Long id) {
		this.ID_alumno = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}
