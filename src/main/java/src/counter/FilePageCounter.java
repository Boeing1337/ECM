package src.counter;

import java.io.File;

public interface FilePageCounter {
    int countPages(File file);
    String getType();
}
