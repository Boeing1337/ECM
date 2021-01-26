package src.service;

import lombok.NonNull;

import java.io.File;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileRetriever {

    public static List<File> retrieve(@NonNull File srcDir) {
        if (!srcDir.isDirectory()) {
            throw new IllegalArgumentException(srcDir.getPath() + " isn't a directory");
        }

        Queue<File> dirs = new ArrayDeque<>();
        List<File> fileList = new LinkedList<>();
        dirs.add(srcDir);

        while (!dirs.isEmpty()) {
            File[] tmpFiles = dirs.poll().listFiles();

            if (tmpFiles == null) {
                continue;
            }

            for (File tmpFile : tmpFiles) {
                if (tmpFile.isFile()) {
                    fileList.add(tmpFile);
                } else if (tmpFile.isDirectory()) {
                    dirs.add(tmpFile);
                }
            }
        }
        return fileList;
    }

}
