package org.jpwh.model.collections.mapofembeddables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Image {

    @Column(nullable = true) // Can be null, not part of PK!
    protected String title;

    @NotNull
    protected int width;

    @NotNull
    protected int height;

    public Image() {
    }

    public Image(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Whenever value-types are managed in collections, overriding equals/hashCode is a good idea!

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image other = (Image) o;

        if (width != other.width) return false;
        if (height != other.height) return false;
        if (!title.equals(other.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }

    // ...
}
