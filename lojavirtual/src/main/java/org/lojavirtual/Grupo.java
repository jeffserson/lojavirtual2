package org.lojavirtual;

import java.io.Serializable;

<<<<<<< HEAD:lojavirtual/src/main/java/org/lojavirtual/Pais.java
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity 
>>>>>>> 59efd7b3e9491abac825425199d600c96bc6ac92:lojavirtual/src/main/java/org/lojavirtual/Grupo.java

public class Grupo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String descricao;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable=false, length=40)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(nullable=false, length=80)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
<<<<<<< HEAD:lojavirtual/src/main/java/org/lojavirtual/Pais.java
=======

	@Override
	public String toString() {
		return "Grupo [nome=" + nome + "]";
	}
>>>>>>> 59efd7b3e9491abac825425199d600c96bc6ac92:lojavirtual/src/main/java/org/lojavirtual/Grupo.java
}
