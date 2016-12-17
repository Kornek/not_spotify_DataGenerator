package com.example.alex.entity;

import javax.persistence.*;

/**
 * Created by Alex on 16.12.2016.
 */
@Entity
@Table(name = "LABELS", schema = "IN130062", catalog = "")
public class Label {
    private long labelid;
    private String labelname;

    @Id
    @Column(name = "LABELID")
    public long getLabelid() {
        return labelid;
    }

    public void setLabelid(long labelid) {
        this.labelid = labelid;
    }

    @Basic
    @Column(name = "LABELNAME")
    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label = (Label) o;

        if (labelid != label.labelid) return false;
        if (labelname != null ? !labelname.equals(label.labelname) : label.labelname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (labelid ^ (labelid >>> 32));
        result = 31 * result + (labelname != null ? labelname.hashCode() : 0);
        return result;
    }
}
