package domain;

import javax.persistence.*;

@Entity
public class Matricula implements BaseEntity<Long> {
	@Id
	@SequenceGenerator(name = "Matricula_ID_GENERATOR", sequenceName = "Matricuala_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Matricula_ID_GENERATOR")
	private Long ID_matricula;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="id", referencedColumnName="ID_curso")
	private Curso curso;
	
	@ManyToOne
    @PrimaryKeyJoinColumn(name="id", referencedColumnName="ID_alumno")
    private Alumno alumno;

	private Double nota;

	private String semestre;

	@Override
	public Long getId() {
		return ID_matricula;
	}

	@Override
	public void setId(Long id) {
		this.ID_matricula = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
