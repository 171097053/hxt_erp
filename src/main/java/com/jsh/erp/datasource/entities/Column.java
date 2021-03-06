package com.jsh.erp.datasource.entities;

public class Column {
    private Long id;

    private String title;

    private String field;

    private String align;

    private String checkbox;

    private String width;

    private String height;

    private Integer hidden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align == null ? null : align.trim();
    }

    public String getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox == null ? null : checkbox.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }
}