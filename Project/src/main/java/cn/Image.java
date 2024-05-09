package cn;

import java.util.Date;
import java.util.List;

public class Image {
    public String id;
    public String name;
    public Date creationDate;
    public List<String> labels;

    public Image() {}

    public void print(List<String> translatedLabels) {
        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Creation Date: " + creationDate);
        System.out.println("Labels: ");
        labels.forEach(label -> System.out.println("- " + label));
        System.out.println("\nTranslated Labels: ");
        translatedLabels.forEach(label -> System.out.println("- " + label));
    }
}