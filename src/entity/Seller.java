package entity;

/**
 * Created by USER on 22.07.2016.
 */
public class Seller {
    int id_seller;
    String name_seller;
    int id_order;

    public Seller(int size, String name_seller) {
    }

    public Seller(int id_seller, String name_seller, int id_order) {
        this.id_seller = id_seller;
        this.name_seller = name_seller;
        this.id_order = id_order;
    }

    public int getId_seller() {
        return id_seller;
    }

    public void setId_seller(int id_seller) {
        this.id_seller = id_seller;
    }

    public String getName_seller() {
        return name_seller;
    }

    public void setName_seller(String name_product) {
        this.name_seller = name_seller;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    @Override
    public String toString() {
        return "entity.Seller{" +
                "id_seller=" + id_seller +
                ", name_seller='" + name_seller + '\'' +
                ", id_order=" + id_order +
                '}';
    }
}
