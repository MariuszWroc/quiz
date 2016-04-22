/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.util;

/**
 *
 * @author Mariusz Czarny
 */
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DirectoryWatcher implements Runnable {
    private String sharedDirectory;
    private WatchService service;

    public DirectoryWatcher(String sharedDirectory) {
        this.sharedDirectory = sharedDirectory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        try {
            Path path = getSharedDirPath(sharedDirectory);
            FileSystem fs = path.getFileSystem();
            service = fs.newWatchService();

            path.register(service, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

            getAllFilesInDirectory();

            WatchKey key = null;
            while (true) {
                key = service.take();

                Kind<?> kind = null;
                for (WatchEvent<?> watchEvent : key.pollEvents()) {

                    kind = watchEvent.kind();

                    if (OVERFLOW == kind) {
                    } else if (ENTRY_CREATE == kind) {
                        path = ((WatchEvent<Path>) watchEvent).context();
                    } else if (ENTRY_MODIFY == kind) {
                        path = ((WatchEvent<Path>) watchEvent).context();
                    } else if (ENTRY_DELETE == kind) {
                        System.out.println("delete");
                        path = ((WatchEvent<Path>) watchEvent).context();
                    }
                }
                if (!key.reset()) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            if (e instanceof java.nio.file.ClosedWatchServiceException) {
                System.out.println("closing wathcer");
            } else {
                e.getMessage();
            }
        }
        System.out.println("thread end");
    }

    public void stopWatching() {
        if (service != null) {
            try {
                service.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    /**
     * function return all the files in the shared directory
     *
     * @throws IOException
     */
    private void getAllFilesInDirectory() throws IOException {
        File folder = new File(sharedDirectory.trim());

        File[] fileList = folder.listFiles();

        if (fileList != null) {
            for (final File fileEntry : fileList) {
                if (!fileEntry.isDirectory()) {
                    Path path = new File(fileEntry.toString()).toPath();

                    if (path != null) {
                    }
                }
            }
        }
    }

    private Path getSharedDirPath(String path) {
        File shared = new File(sharedDirectory.trim());
        if (!shared.exists()) {
            if (shared.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        return shared.toPath();
    }

    public void setSharedDirectory(String sharedDirectory) {
        this.sharedDirectory = sharedDirectory;
    }

}
