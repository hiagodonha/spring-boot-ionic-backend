package com.hiagodonha.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hiagodonha.mc.dao.CategoriaDao;
import com.hiagodonha.mc.dao.CidadeDao;
import com.hiagodonha.mc.dao.ClienteDao;
import com.hiagodonha.mc.dao.EnderecoDao;
import com.hiagodonha.mc.dao.EstadoDao;
import com.hiagodonha.mc.dao.ProdutoDao;
import com.hiagodonha.mc.model.Categoria;
import com.hiagodonha.mc.model.Cidade;
import com.hiagodonha.mc.model.Cliente;
import com.hiagodonha.mc.model.Endereco;
import com.hiagodonha.mc.model.Estado;
import com.hiagodonha.mc.model.Produto;
import com.hiagodonha.mc.model.enums.TipoCliente;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaDao categoriaDao;
	@Autowired
	private ProdutoDao produtoDao;
	@Autowired
	private EstadoDao estadoDao;
	@Autowired
	private CidadeDao cidadeDao;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private EnderecoDao enderecoDao;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaDao.saveAll(Arrays.asList(cat1,cat2));
		produtoDao.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Uberlândia");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoDao.saveAll(Arrays.asList(est1,est2));
		cidadeDao.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("1111111", "22222"));
		
		Endereco e1 = new Endereco(null, "rua teste", "2", "qd k lt 10", "vila", "746333300", cli1, c1);
		Endereco e2 = new Endereco(null, "av matos", "105", "sala 800", "centro", "746333300", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteDao.saveAll(Arrays.asList(cli1));
		
		enderecoDao.saveAll(Arrays.asList(e1,e2));
		
		
		
	}

}
