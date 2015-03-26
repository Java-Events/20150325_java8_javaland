package org.rapidpm.course.java8.streams.chap_1_4;

import java.util.Objects;

/**
* Created by Sven Ruppert on 22.11.13.
*/
public class ChartValue {
    public double x;
    public double y;

    public ChartValue(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ChartValue other = (ChartValue) obj;
        return Objects.equals(this.x, other.x) && Objects.equals(this.y, other.y);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChartValue{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
