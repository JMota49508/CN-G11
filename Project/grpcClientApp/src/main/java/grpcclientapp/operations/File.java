package grpcclientapp.operations;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class File {
    String name;
    public byte[] bytes;
    public String contentType;

    public File(String name, byte[] bytes, String contentType) {
        this.name = name;
        this.bytes = bytes;
        this.contentType = contentType;
    }
}
