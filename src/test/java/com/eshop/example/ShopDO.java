package com.eshop.example;

import java.util.Objects;

class ShopDO {
        private Integer id;
    private String name;

    public ShopDO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopDO shopDO = (ShopDO) o;
        return id == shopDO.id && Objects.equals(name, shopDO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ShopDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

