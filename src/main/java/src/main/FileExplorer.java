package src.main;

import lombok.NonNull;
import org.apache.commons.io.FilenameUtils;
import src.counter.FilePageCounter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileExplorer {
    private final Map<String, FilePageCounter> counterMap = new HashMap<>();

    public FileExplorer(@NonNull List<FilePageCounter> counterList) {
        counterList.forEach(c -> counterMap.put(c.getType(), c));
    }

    public CountResult countByExtension(@NonNull List<File> files) {
        int documents = 0;
        int pages = 0;

        for (File f : files) {
            String extension = FilenameUtils.getExtension(f.getName());
            if (extension.isEmpty()) continue;

            FilePageCounter counter = counterMap.get(extension);
            if (counter == null) continue;

            pages += counter.countPages(f);
            documents++;
        }

        return new CountResult(documents, pages);
    }

}
