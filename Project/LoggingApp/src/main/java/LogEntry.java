import java.util.UUID;

public class LogEntry {
    public String id;
    public String entry;

    public LogEntry(UUID id, String entry) {
        this.id = id.toString();
        this.entry = entry;
    }
}
