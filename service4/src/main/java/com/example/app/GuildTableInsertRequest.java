package com.example.app;

public class GuildTableInsertRequest {

    private Integer id;
    private Integer parentid;
    private String name;
    private String color;

    protected GuildTableInsertRequest() {}

    public GuildTableInsertRequest(Integer id, Integer parentid, String name, String color) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.color = color;
    }

    public Integer getParentid() {
        return parentid;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "GuildTableInsertRequest{" +
                "id=" + id +
                "parentid=" + parentid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
