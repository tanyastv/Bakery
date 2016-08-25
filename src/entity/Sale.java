package entity;

import java.sql.Date;

/**
 * Class describe sale entity
 * @author Sarnavskaya
 */
public class Sale {
    private int id_sale;
    private int id_seller;
    private int id_product;
    private int cost_sale;
    private Date date_of_sale;

    public Sale(int size) {
    }

    public Sale(int id_sale, int id_seller, int id_product, int cost_sale, Date date_of_sale) {
        this.id_sale = id_sale;
        this.id_seller = id_seller;
        this.id_product = id_product;
        this.cost_sale = cost_sale;
        this.date_of_sale = date_of_sale;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public int getId_seller() {
        return id_seller;
    }

    public void setId_seller(int id_seller) {
        this.id_seller = id_seller;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getCost_sale() {
        return cost_sale;
    }

    public void setCost_sale(int cost_sale) {
        this.cost_sale = cost_sale;
    }

    public Date getDate_of_sale() {
        return date_of_sale;
    }

    public void setDate_of_sale(Date date_of_sale) {
        this.date_of_sale = date_of_sale;
    }

    @Override
    public String toString() {
        return "entity.Sale{" +
                "id_sale=" + id_sale +
                "id_seller=" + id_seller +
                "id_product=" + id_product +
                ", cost_sale='" + cost_sale + '\'' +
                ", date_of_sale=" + date_of_sale +
                '}';
    }
}
