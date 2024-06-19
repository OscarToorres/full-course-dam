package tarea3_5;

import java.util.Arrays;

public class Alumna {

	private String nome;
	private String ciclo;
	private String modulo;
	private int curso;
	private int[] cualificacions;
	
	public Alumna(String nome, String ciclo, String modulo, int curso, int[] cualificacions) {
		super();
		this.nome = nome;
		this.ciclo = ciclo;
		this.modulo = modulo;
		this.curso = curso;
		this.cualificacions = cualificacions;
	}

	public String getNome() {
		return nome;
	}

	public String getCiclo() {
		return ciclo;
	}

	public String getModulo() {
		return modulo;
	}

	public int getCurso() {
		return curso;
	}

	public int[] getCualificacions() {
		return cualificacions;
	}

	@Override
	public String toString() {
		return "Alumna [nome=" + nome + ", ciclo=" + ciclo + ", modulo=" + modulo + ", curso=" + curso
				+ ", cualificacions=" + Arrays.toString(cualificacions) + "]";
	}
	
}
