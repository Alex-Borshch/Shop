package dao.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_category")
public class ProductCategory extends Model {

    private String title;
    private Set<Product> products = new HashSet<>();
    private ProductCategory parentProductCategory;
    private String imgPath;
    private String path;

    public ProductCategory() {
        super();
    }
    public ProductCategory(String title){
        this.title = title;
    }
    public ProductCategory(String title, String imgPath,String path){
        this.title = title;
        this.imgPath = imgPath;
        this.path = path;
    }
    public ProductCategory(long id) {
        super(id);
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_product_category",
            referencedColumnName = "id")
    public ProductCategory getParentProductCategory() {
        return parentProductCategory;
    }

    public void setParentProductCategory(ProductCategory parentProductCategory) {
        this.parentProductCategory = parentProductCategory;
    }
    @OneToMany (mappedBy = "productCategory")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Column(name = "imagePath")
    public String getImgPath() {
        return imgPath;
    }

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}

