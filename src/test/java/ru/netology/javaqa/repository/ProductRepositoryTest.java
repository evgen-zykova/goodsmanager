package ru.netology.javaqa.repository;
import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Smartphone;

public class ProductRepositoryTest {

    Product product1 = new Smartphone(11, "Айфон", 100_000, "Apple");
   Product product2 = new Book(152,"Война и мир", 500, "Толстой");
   Product product3 = new Smartphone(18, "Самсунг R50", 80_000,"Samsung" );
   Product product4 = new Book(15, "Идиот", 700, "Достоевский");

   @Test

   public void save () {
       ProductRepository repository = new ProductRepository();
       repository.save(product1);
       repository.save(product2);
       repository.save(product3);
       repository.save(product4);

       Product[] expected = {product1, product2, product3, product4};
       Product[] actual = repository.findAll();

       Assertions.assertArrayEquals(expected, actual);
   }

   @Test
    public void removeById() {
       ProductRepository repository = new ProductRepository();
       repository.save(product1);
       repository.save(product2);
       repository.save(product3);
       repository.save(product4);
       repository.removeById(product2.getId());

       Product[] expected = {product1, product3, product4};
       Product[] actual = repository.findAll();

       Assertions.assertArrayEquals(expected, actual);



   }
}
