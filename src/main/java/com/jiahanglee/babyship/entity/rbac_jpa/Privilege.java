package com.jiahanglee.babyship.entity.rbac_jpa;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Integer status;
    private Integer level;
    @CreationTimestamp
    @Column(name = "create_time",columnDefinition="DATETIME COMMENT '添加时间'")
    private Timestamp createTime;
    @UpdateTimestamp
    @Column(name = "update_time",columnDefinition="DATETIME COMMENT '最后更新时间'")
    private Timestamp updateTime;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @JoinColumn(name = "id")
    private Set<Menu> menu = new HashSet<>();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", level=" + level +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", menu=" + menu +
                '}';
    }
}
