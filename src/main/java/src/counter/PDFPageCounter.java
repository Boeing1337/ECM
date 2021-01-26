package src.counter;

import org.apache.pdfbox.pdmodel.PDDocument;
import src.counter.data.Extension;

import java.io.File;

import static src.counter.data.Extension.PDF;

public class PDFPageCounter implements FilePageCounter {
    private final static Extension EXTENSION = PDF;

    @Override
    public int countPages(File file) {
        int pages = 0;
        try (PDDocument load = PDDocument.load(file)) {
            pages = load.getNumberOfPages();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pages;
    }

    @Override
    public String getType() {
        return EXTENSION.getType();
    }
}
