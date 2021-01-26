package src.count;

import org.apache.pdfbox.pdmodel.PDDocument;
import src.count.data.Extension;

import java.io.File;

public class PDFPageCount implements FilePageCount {
    private final static Extension EXTENSION = Extension.PDF;

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
