package src.service;

import lombok.NonNull;
import org.apache.commons.io.FilenameUtils;
import src.dto.CountResult;
import src.count.DocPageCount;
import src.count.DocxPageCount;
import src.count.FilePageCount;
import src.count.PDFPageCount;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilePageCalculator {
    private final Map<String, FilePageCount> counterMap = new HashMap<>();

    public FilePageCalculator() {
        List.of(new DocPageCount(),
                new DocxPageCount(),
                new PDFPageCount())
                .forEach(c -> counterMap.put(c.getType(), c));
    }

    public CountResult calculate(@NonNull List<File> files) {
        int documents = 0;
        int pages = 0;

        for (File f : files) {
            String extension = FilenameUtils.getExtension(f.getName());
            if (extension.isEmpty()) {
                continue;
            }

            FilePageCount counter = counterMap.get(extension);
            if (counter == null) {
                continue;
            }

            pages += counter.countPages(f);
            documents++;
        }

        return new CountResult(documents, pages);
    }

}
