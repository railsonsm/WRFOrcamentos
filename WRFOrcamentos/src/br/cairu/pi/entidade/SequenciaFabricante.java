package br.cairu.pi.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fabricante_sequencia")
public class SequenciaFabricante {
	@Id
	private Integer next_val;

	public Integer getNext_val() {
		return next_val;
	}

	public void setNext_val(Integer next_val) {
		this.next_val = next_val;
	}
}
