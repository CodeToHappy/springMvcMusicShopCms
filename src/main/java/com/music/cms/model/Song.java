package com.music.cms.model;

import com.music.cms.validator.ImageValidationMime;
import com.music.cms.validator.ImageValidationSize;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be empty!")
    private String title;

    @NotEmpty(message = "Singer name cannot be empty!")
    private String singer;

    @NotNull(message = "Status must be specified!")
    private Boolean status;

    @NotNull(message = "Price field cannot be empty!")
    private Long price;

    @NotNull(message = "Stock must be specified!")
    @Range(min=0, max=10000)
    private Integer stock;

    @Column(nullable = true)
    @NumberFormat
    @Range(min=1, max=100)
    private Long discount;

    @Column(nullable=true)
    private String image;

    @Transient
    @ImageValidationSize
    @ImageValidationMime
    private MultipartFile file;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
