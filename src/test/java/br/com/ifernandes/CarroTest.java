/**
 * 
 */
package br.com.ifernandes;


import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Test;

import br.com.ifernandes.dao.AcessorioDao;
import br.com.ifernandes.dao.CarroDao;
import br.com.ifernandes.dao.IAcessorioDao;
import br.com.ifernandes.dao.ICarroDao;
import br.com.ifernandes.dao.IMarcaDao;
import br.com.ifernandes.dao.MarcaDao;
import br.com.ifernandes.domain.Acessorio;
import br.com.ifernandes.domain.Carro;
import br.com.ifernandes.domain.Marca;

/**
 * 
 */
public class CarroTest {
	
	private IMarcaDao marcaDao;

	private ICarroDao carroDao;

	private IAcessorioDao acessorioDao;
	
	public CarroTest() {
		marcaDao = new MarcaDao();		
		carroDao = new CarroDao();
		acessorioDao = new AcessorioDao();
	}
	
	@Test
	public void cadastrar() {
		
		Carro carro = criarCarro("Civic");

		Marca marca = new Marca();
		marca.setCodigo("A1");
		marca.setDataMatricula(Instant.now());
		marca.setStatus("ATIVA");
		marca.setValor(2000d);		

		carro.setMarca(marca);
		marca = marcaDao.cadastrar(marca);

		assertNotNull(marca);
		assertNotNull(marca.getId());		
	}

	private Acessorio criarAcessorio(String codigo) {
		Acessorio acess = new Acessorio();
		acess.setCodigo(codigo);
		acess.setDescricao("Comp 1");
		return acessorioDao.cadastrar(acess);	
	}

	private Carro criarCarro(String codigo) {
		Acessorio comp = criarAcessorio("A1");
		Acessorio comp2 = criarAcessorio("A2");
		Carro carro = new Carro();
		carro.setCodigo(codigo);
		carro.setNome("Rodrigo");
		carro.add(comp);
		carro.add(comp2);		
		return carroDao.cadastrar(carro);
	}
}
