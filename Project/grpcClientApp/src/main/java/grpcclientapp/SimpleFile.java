package grpcclientapp;

public class SimpleFile {
    String name;
    public byte[] bytes;
    public String contentType;

    public SimpleFile(String name, byte[] bytes, String contentType) {
        this.name = name;
        this.bytes = bytes;
        this.contentType = contentType;
    }
}
