package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso implements BaseEntity<Long> {
	@Id
	@SequenceGenerator(name = "Curso_ID_GENERATOR", sequenceName = "Curso_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Curso_ID_GENERATOR")
	private Long ID_curso;

	private String codigo;

	private String nombre;

	private Integer creditos;
	
	@ManyToMany
	@JoinTable(name = "curso_prerequisitos",
		joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "ID_curso", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "prerequisito_id", referencedColumnName = "ID_curso",nullable = false))
	private List<Curso> prerequisitos;
	
	@OneToMany(mappedBy = "curso")
	private List<Matricula> alumnos;
	
	@Override
	public Long getId() {
		return ID_curso;
	}

	@Override
	public void setId(Long id) {
		this.ID_curso = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public List<Curso> getPrerequisitos() {
		return prerequisitos;
	}

	public void setPrerequisitos(List<Curso> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

}
