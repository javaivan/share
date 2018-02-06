package com.share.core.model.embeddable;

public class Role {
    /*@Id
    public String id;*/

    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
