package ru.netology.javaqa.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.domain.Smartphone;
import ru.netology.javaqa.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Smartphone(11, "Айфон 10", 100_000, "Apple");
    Product product2 = new Book(152, "Война и мир", 500, "Толстой");
    Product product3 = new Smartphone(18, "Айфон 13", 80_000, "Apple");

    Product product4 = new Book(15, "Идиот", 700, "Достоевский");


    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }

    @Test

    public void shouldGetAll() {
        Product[] expected = new Product[]{product1, product2, product3, product4};
        Product[] actual = manager.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldSearchByText() {
        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Война");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByPartOfWord() {
        Product[] expected = {product4};
        Product[] actual = manager.searchBy("от");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchForNonExistentName() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("стол");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchForMultipleProducts() {

        Product[] expected = {product1, product3};
        Product[] actual = manager.searchBy("Айфон");

        Assertions.assertArrayEquals(expected, actual);
    }
}









