import src.counter.DocPageCounter;
import src.counter.DocxPageCounter;
import src.counter.FilePageCounter;
import src.counter.PDFPageCounter;
import src.main.CountResult;
import src.main.FileExplorer;
import src.service.FileScanner;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static FileExplorer FILE_EXPLORER;

    static {
        List<FilePageCounter> pageCounters = List.of(
                new DocPageCounter(), new DocxPageCounter(), new PDFPageCounter());
        FILE_EXPLORER = new FileExplorer(pageCounters);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("type path: ");
            String path = SCANNER.nextLine();
            try {
                List<File> fileList = new FileScanner(new File(path)).retrieveAll();
                CountResult countResult = FILE_EXPLORER.countByExtension(fileList);

                System.out.println(countResult);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
