package dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product extends Model {

    private String title;
    private String description;
    private BigDecimal price;
    private int quantity;
    private ProductCategory productCategory;
    private String imagePath;
    private boolean isInStoke;


    public Product() {
        super();
    }

    public Product(long id) {
        super(id);
    }

    public Product(String title, String description, BigDecimal price, int quantity) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String title, String description, BigDecimal price, int quantity,
                   ProductCategory productCategory, String imagePath) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.productCategory = productCategory;
        this.imagePath = imagePath;
    }

    public Product(String title, String description, BigDecimal price,
                   int quantity, ProductCategory productCategory, String imagePath, boolean isInStoke) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.productCategory = productCategory;
        this.imagePath = imagePath;
        this.isInStoke = isInStoke;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        String rez = this.title + ", price: " + this.price;
        return rez;
    }

    @Column(name = "imagePath")
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Column(name = "isInStoke")
    public boolean isInStoke() {
        return isInStoke;
    }

    public void setInStoke(boolean inStoke) {
        isInStoke = inStoke;
    }
}
