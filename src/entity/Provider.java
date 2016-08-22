package entity;

import java.util.Date;

/**
 * Created by USER on 21.07.2016.
 */
public class Provider {
    int id_provider;
    int id_product;
    Date date_of_delivery;
    String name_provider;

    public Provider(int size, String name_provider) {
    }

    public Provider(int id_provider, int id_product, Date date_of_delivery, String name_provider) {
        this.id_provider = id_provider;
        this.id_product = id_product;
        this.date_of_delivery = date_of_delivery;
        this.name_provider = name_provider;

    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public Date getDate_of_delivery() {
        return date_of_delivery;
    }

    public void setDate_of_delivery(Date date_of_delivery) {
        this.date_of_delivery = date_of_delivery;
    }

    public String getName_provider() {
        return name_provider;
    }

    public void setName_provider(String name_provider) {
        this.name_provider = name_provider;
    }

    @Override
    public String toString() {
        return "entity.Provider{" +
                "id_provider=" + id_provider +
                "id_product=" + id_product +
                "date_of_delivery=" + date_of_delivery + '\'' +
                ", name_provider='" + name_provider +
                '}';
    }
}
