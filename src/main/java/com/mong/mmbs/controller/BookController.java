spackage com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.service.BookListService;

@RestController
@RequestMapping("/api/book")

public class BookController<BookListServicevice> {
	
	@Autowired BookListService bookListService;

	@GetMapping("/bookList")
	public ResponseDto<?> getBookList() {
		return bookListService.getBookList();
	}
}
