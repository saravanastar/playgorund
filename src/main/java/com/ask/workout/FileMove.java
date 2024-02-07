package com.ask.workout;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

public class FileMove {
    static final String SOURCE_PATH = "/Users/asaravanakum/Downloads/gphotos/Takeout";

    static final String DEST_PATH = "./synology";
    AtomicInteger fileCounter;
    AtomicInteger folderCounter;

    Path copyPath;

    FileMove() throws IOException {
        fileCounter = new AtomicInteger(0);
        folderCounter = new AtomicInteger(0);
        copyPath = Paths.get(DEST_PATH);
        createDirectory(copyPath);
    }

    private void createDirectory(Path path) throws IOException {
        Files.createDirectories(path);
    }

    public static void main(String[] args) throws IOException {
        FileMove fileMove = new FileMove();
        fileMove.moveFile(new File(SOURCE_PATH));
    }

    void moveFile(File file) throws IOException {
        File[] files = file.listFiles();
        for (File listFile : files) {
            if (listFile.isDirectory()) {
                moveFile(listFile);
            } else {
                if (listFile.isFile()) {
                    String mimeType = Files.probeContentType(listFile.toPath());
                    if (mimeType!= null && mimeType.contains("image")) {
                        copyFile(listFile);
                    }
                }
            }
        }
    }

    void copyFile(File file) throws IOException {
        System.out.println("moving file "+ file.getName());
        Paths.get(file.getAbsolutePath() + ".json");
        BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        System.out.println("creationTime: " + attr.creationTime());
        int count = fileCounter.getAndIncrement();
        if (count % 5000 == 0) {
            createDirectory(Paths.get(DEST_PATH, "data"+ folderCounter.incrementAndGet()));
        }
        Path target = Paths.get(DEST_PATH, "data"+ folderCounter.get(), file.getName());
        Path originalPath = file.toPath();
        Files.copy(originalPath, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
