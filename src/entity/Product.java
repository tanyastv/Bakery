package entity;

/**
 * @author Sarnavskaya
 */

/**
 * class Product - класс, описывающий сущность Заказы
 * id_product - идентификтор продукта
 * name_product - название продукта
 * cost - цена
 */

public class Product {
    int id_product;
    String name_product;
    int cost;

    public Product(int size, String name_product) {
    }

    public Product(int id_product, String name_product, int cost) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.cost = cost;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "entity.Product{" +
                "id_product=" + id_product +
                ", name_product='" + name_product + '\'' +
                ", cost=" + cost +
                '}';
    }
}
