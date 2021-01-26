package src.service;

import lombok.NonNull;

import java.io.File;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileScanner {
    private final Queue<File> dirs = new ArrayDeque<>();

    public FileScanner(@NonNull File srcDir) {
        if (!srcDir.isDirectory())
            throw new IllegalArgumentException(srcDir.getPath() + " isn't a directory");

        dirs.add(srcDir);
    }

    public List<File> retrieveAll() {
        List<File> fileList = new LinkedList<>();

        while (!dirs.isEmpty()) {
            File[] tmpFiles = dirs.poll().listFiles();

            if (tmpFiles == null) continue;

            for (File e : tmpFiles) {
                if (e.isFile()) {
                    fileList.add(e);
                } else if (e.isDirectory()) {
                    dirs.add(e);
                }
            }
        }
        return fileList;
    }

}
