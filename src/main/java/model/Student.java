package model;

public class Student {
    private Long id;
    private String name;
    private String address;
    private String imageID;

    public Student() {
    }

    public Student(Long id, String name, String address, String imageID) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.imageID = imageID;
    }

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
}
