import src.dto.CountResult;
import src.service.FilePageCalculator;
import src.service.FileRetriever;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class PageCalcApp {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static FilePageCalculator FILE_PAGE_CALCULATOR = new FilePageCalculator();
    private final static boolean INFINITY = true;

    public static void main(String[] args) {
        while (INFINITY) {
            System.out.println("type path: ");
            String path = SCANNER.nextLine();
            try {
                List<File> fileList = FileRetriever.retrieve(new File(path));
                CountResult countResult = FILE_PAGE_CALCULATOR.calculate(fileList);

                System.out.println(countResult);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
