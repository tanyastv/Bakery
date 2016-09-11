package entity;

/**
 * Class describe orders entity
 *
 * @author Sarnavskaya
 */
public class Order {
    private int id_order;
    private String name_order;
    private int id_product;
    private int id_provider;
    private int nds;

    public Order(int id_order, String name_order, int id_product, int id_provider, int nds) {
        this.id_order = id_order;
        this.name_order = name_order;
        this.id_product = id_product;
        this.id_provider = id_provider;
        this.nds = nds;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String getName_order() {
        return name_order;
    }

    public void setName_order(String name_order) {
        this.name_order = name_order;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public int getNds() {
        return nds;
    }

    public void setNds(int nds) {
        this.nds = nds;
    }

    @Override
    public String toString() {
        return "entity.Order{" +
                "id_order=" + id_order +
                ", name_order=" + name_order +
                ", id_product=" + id_product +
                ", id_provider='" + id_provider + '\'' +
                ", nds=" + nds +
                '}';
    }
}
