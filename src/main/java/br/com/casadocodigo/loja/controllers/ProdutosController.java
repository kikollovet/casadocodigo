package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.conf.JsonViewResolver;
import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@CacheEvict(value="produtosHome", allEntries = true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		
		
		if(result.hasErrors()) {
			return form(produto);
		}
		
		//String path = fileSaver.write("images", sumario);
		//String path = fileSaver.write("arquivos-sumario", sumario);
		String path = fileSaver.write("files", sumario);
		//String path = fileSaver.write("imagens", sumario);
		produto.setSumarioPath(path);
		
		produtoDao.gravar(produto);
		
		
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!!");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
	
	@RequestMapping("/detalhe/{id}")
	@ResponseBody
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		modelAndView.addObject("produto", produto);
		
		return modelAndView;
	}
	
	@ExceptionHandler(NoResultException.class)
	public String trataDetalheNaoEcontrado(){
	    return "error";
	}
	
	
	
	//Retorno JSON
	
//	@RequestMapping("/{id}")
//	@ResponseBody
//	public Produto detalheJson(@PathVariable("id") Integer id) {
//
//		return produtoDao.find(id);
//	}

}
