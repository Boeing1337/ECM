package src.count;

import com.aspose.words.Document;
import lombok.SneakyThrows;
import src.count.data.Extension;

import java.io.File;

public class DocPageCount implements FilePageCount {
    private final static Extension EXTENSION = Extension.DOC;

    @Override
    @SneakyThrows
    public int countPages(File file) {
        return new Document(file.getAbsolutePath()).getPageCount();
    }

    @Override
    public String getType() {
        return EXTENSION.getType();
    }
}
