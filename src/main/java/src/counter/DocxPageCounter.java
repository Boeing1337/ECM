package src.counter;

import com.aspose.words.Document;
import lombok.SneakyThrows;
import src.counter.data.Extension;

import java.io.File;

import static src.counter.data.Extension.DOCX;

public class DocxPageCounter implements FilePageCounter {
    private final static Extension EXTENSION = DOCX;

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
