package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class JoinProCat {

    @Id
    private Integer pid;
    private Integer cid;
    private Integer price;
    private String ptitle;
    private String title;


}
