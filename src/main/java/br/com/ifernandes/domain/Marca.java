/**
 * 
 */
package br.com.ifernandes.domain;

import java.time.Instant;

/**
 * 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MARCA")
public class Marca {
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="marca_seq")
		@SequenceGenerator(name="marca_seq", sequenceName="sq_marca", initialValue = 1, allocationSize = 1)
		private Long id;

		@Column(name = "CODIGO", length = 10, nullable = false, unique = true)
		private String codigo;

		@Column(name = "DATA_MARCA", nullable = false)
		private Instant dataMatricula;

		@Column(name = "valor", nullable = false)
		private Double valor;

		@Column(name = "status", nullable = false)
		private String status;

		@ManyToOne
		@JoinColumn(name = "id_carro_fk", 
			foreignKey = @ForeignKey(name = "fk_carro_marca"), 
			referencedColumnName = "id", nullable = false
		)
		private Carro carro;

		@OneToOne
		@JoinColumn(name = "id_acessorio_fk", 
			foreignKey = @ForeignKey(name = "fk_acessorio_marca"), 
			referencedColumnName = "id", nullable = false
		)	
		private Acessorio acessorio;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public Instant getDataMatricula() {
			return dataMatricula;
		}

		public void setDataMatricula(Instant dataMatricula) {
			this.dataMatricula = dataMatricula;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Carro getCarro() {
			return carro;
		}

		public void setCurso(Carro carro) {
			this.carro = carro;
		}

		public Acessorio getAcessorio() {
			return acessorio;
		}

		public void setAcessorio(Acessorio acessorio) {
			this.acessorio = acessorio;
		}
}

