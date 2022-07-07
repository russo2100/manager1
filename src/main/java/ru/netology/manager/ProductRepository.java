package ru.netology.manager;

public class ProductRepository {
    private Product[] product = new Product[0];

    public void save(Product item) {
        int length = product.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(product, 0, tmp, 0, product.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        product = tmp;
    }

    public Product[] findAll() {
        return product;
    }

    public void removeById(int id) {
        if (id < 0) {
            throw new NotFoundException(
                    "ID не может быть отрицательным" + id
            );
        }
        Product[] tmp = new Product[product.length -1];
        int index = 0;
        for (Product item : product) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        product = tmp;
    }
}