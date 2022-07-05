package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Book;
import ru.netology.manager.Product;
import ru.netology.manager.Smartphone;
import ru.netology.manager.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Alice’s Adventures in Wonderland", 228, "Lewis Carroll");
    private Book secondBook = new Book(2, "Through the Looking-Glass, and What Alice Found There", 307, "Lewis Carroll");
    private Smartphone firstSmartphone = new Smartphone(3, "8.3", 49_990, "Nokia");
    private Smartphone secondSmartphone = new Smartphone(4, "5.3 4/64", 15_990, "Nokia");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone,};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Alice’s Adventures in Wonderland");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{secondSmartphone};
        Product[] actual = manager.searchBy("5.3 4/64");
        assertArrayEquals(expected, actual);
    }


}
