package src.count;

import java.io.File;

public interface FilePageCount {
    int countPages(File file);
    String getType();
}
