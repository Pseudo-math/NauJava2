import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSynchronizer implements Task {
    private Path sourceFolder;
    private Path destinationFolder;
    private boolean running = false;

    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = Paths.get(sourceFolder);
    }

    public void setDestinationFolder(String destinationFolder) {
        this.destinationFolder = Paths.get(destinationFolder);
    }

    @Override
    public void start() {
        if (running) {
            System.out.println("Synchronization is already running!");
            return;
        }
        running = true;
        synchronize();
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("Synchronization stopped.");
    }

    private void synchronize() {
        try {
            if (sourceFolder == null || destinationFolder == null) {
                System.err.println("Source or destination folder is not set.");
                return;
            }

            Files.walkFileTree(sourceFolder, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!running) return FileVisitResult.TERMINATE;

                    Path relativePath = sourceFolder.relativize(file);
                    Path targetPath = destinationFolder.resolve(relativePath);

                    if (Files.notExists(targetPath) || !Files.isSameFile(file, targetPath)) {
                        Files.copy(file, targetPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Synchronized: " + file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Synchronization completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
