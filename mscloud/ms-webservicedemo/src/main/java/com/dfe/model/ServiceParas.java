package com.dfe.model;
import javax.management.Attribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @auther DUJW
 * @create 2020/3/10
 */
public class ServiceParas {

    private List<Attribute> attribute;

    @XmlElement
    public List<Attribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<Attribute> attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "ServiceParas{" +
                "attribute=" + attribute.toString() +
                '}';
    }
}