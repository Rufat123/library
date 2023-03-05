package az.developia.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.library.model.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {

}
