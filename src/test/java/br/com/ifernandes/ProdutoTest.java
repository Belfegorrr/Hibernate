package br.com.ifernandes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.ifernandes.dao.CursoDao;
import br.com.ifernandes.dao.ICursoDao;
import br.com.ifernandes.dao.IProdutoDao;
import br.com.ifernandes.dao.ProdutoDao;
import br.com.ifernandes.domain.Curso;
import br.com.ifernandes.domain.Produto;

public class ProdutoTest {
	private IProdutoDao produtoDao;

	private ICursoDao cursoDao;

	public ProdutoTest() {
		produtoDao = new ProdutoDao();
		cursoDao = new CursoDao();
	}

	@Test
	public void cadastrar() {
		Curso curso = criarCurso("A1");
		Produto prod = new Produto();
		prod.setCodigo("A1");		
		prod.setStatus("ATIVA");
		prod.setValor(2000d);
		prod.setCurso(curso);
		prod = produtoDao.cadastrar(prod);

		assertNotNull(prod);
		assertNotNull(prod.getId());
	}

	private Curso criarCurso(String codigo) {
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		curso.setDescricao("CURSO TESTE");
		curso.setNome("Curso de Java Backend");
		return cursoDao.cadastrar(curso);
	}

}