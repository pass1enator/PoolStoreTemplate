/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.poolstoretemplate.aplication;

import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Positive;

/**
 *
 * @author Pedro
 */
public class Product {

    private int id;
    @NotEmpty
    @NotNull
    private String name;
    @Positive
  
    private double price;
    @Positive
   
    private int stock;
    @Positive
    private int minstock;
    @NotNull
    @NotEmpty
    private String description;
    private Category category;

    public List<Product> findProduct(Collection<Product> collection) {
        return null;
    }

    public Product() {
        this.name = "";
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinstock() {
        return minstock;
    }

    public void setMinstock(int minstock) {
        this.minstock = minstock;
    }

    public String toString() {
        return "Id:" + this.id + " name:" + this.description + " price:" + this.price + " stock:" + this.stock + " min stock:" + this.minstock;
    }

    public void sale(int units) throws Exception {
        if (this.stock - units >= 0) {
            this.stock -= units;
            if (this.stock < this.minstock) {
            }
        } else {
            throw new Exception("No existe stock suficiente");
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
