package br.com.innmanager.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.innmanager.controllers.BookController;
import br.com.innmanager.data.vo.v1.BooksVO;
import br.com.innmanager.exceptions.RequiredObjectsNullException;
import br.com.innmanager.exceptions.ResourceNotFoundException;
import br.com.innmanager.mapper.DozerMapper;
import br.com.innmanager.model.Book;
import br.com.innmanager.repositories.BooksRepository;

@Service
public class BooksServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	BooksRepository repository;
	
	public List<BooksVO> findAll() {
		
		logger.info("Finding all books!");
		
		var books =  DozerMapper.parseListObjects(repository.findAll(), BooksVO.class);
		books.stream().forEach(b -> b.add(linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()));
		return books;
	}
	
	public BooksVO findById(Long id) {
		
		logger.info("Finding one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
			var vo = DozerMapper.parseObject(entity, BooksVO.class);
			vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public BooksVO create(BooksVO book) {		
		
		if (book == null) throw new RequiredObjectsNullException();
		
		logger.info("Creating one book!");
		
		var entity = DozerMapper.parseObject(book, Book.class);
		repository.save(entity);
		var vo = DozerMapper.parseObject(entity, BooksVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public BooksVO update(BooksVO book) {			
		if (book == null) throw new RequiredObjectsNullException();
		
		logger.info("Updating one book!");
		
		var entity = repository.findById(book.getKey())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		repository.save(entity);
		
		var vo = DozerMapper.parseObject(entity, BooksVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one book!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);		
	}

}