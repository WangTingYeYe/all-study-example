package designpatterns.prototype;

import java.io.Serializable;

public class ReferenceObject implements Cloneable, Serializable {

    private static final long serialVersionUID = 4136927665695708531L;
    private String name;


    @Override
    public String toString() {
        return "ReferenceObject{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
