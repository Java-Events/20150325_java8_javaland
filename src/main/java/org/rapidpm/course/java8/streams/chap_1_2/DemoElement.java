package org.rapidpm.course.java8.streams.chap_1_2;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Sven Ruppert on 15.11.13.
 */
public class DemoElement {

    private String value;
    private Date datum;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DemoElement{");
        sb.append("value='").append(value).append('\'');
        sb.append(", datum=").append(datum);
        sb.append('}');
        return sb.toString();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, datum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final DemoElement other = (DemoElement) obj;
        return Objects.equals(this.value, other.value) && Objects.equals(this.datum, other.datum);
    }
}
