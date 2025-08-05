package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;	

	public List<BookDTO> getAll(){
		var books = bookRepository.findAll();
		var result = books.stream()
						.map(bookMapper::map)
						.toList();
		return result;
	}

	public BookDTO findById(Long id){
		var book = bookRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
		var bookDTO = bookMapper.map(book);
		return bookDTO;
	}
	
	public BookDTO create(BookCreateDTO dtoData){
		var book = bookMapper.map(dtoData);
		bookRepository.save(book);
		var dto = bookMapper.map(book);
		return dto;
	}
	
	public BookDTO update(BookUpdateDTO dto, Long id){
		var book = bookRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
		bookMapper.update(dto, book);
		bookRepository.save(book);
		var bookDto = bookMapper.map(book);
		return bookDto;
	}
	
	public void delete(Long id){
		bookRepository.deleteById(id);
	}            
    // END
}
