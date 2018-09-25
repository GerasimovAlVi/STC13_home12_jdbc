package ru.innopolis.classwork12.realExample.dao.Pojo;

public class Mobile {
    private Integer id;
    private String model;
    private Long price;
    private Manufacture manufacture;

    public Mobile() {
    }

    public Mobile(Integer id, String model, Long price, Manufacture manufacture) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.manufacture = manufacture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufacture=" + manufacture +
                '}';
    }
}
