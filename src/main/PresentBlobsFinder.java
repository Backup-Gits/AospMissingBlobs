package main;

import java.io.File;
import java.util.List;

/*
 * PresentBlobsFinder searches given directories for files and populates a BlobGroup with the blobs found.
 */
public class PresentBlobsFinder {
    public void findBlobsInDirectories(List<File> directories, BlobGroup presentBlobs) {
        for (File directory : directories) {
            if (!directory.isDirectory()) {
                continue;
            }

            for (File blobFile : directory.listFiles()) {
                if (!blobFile.isFile())
                    continue;

                Blob blob = new Blob(blobFile);
                for (Blob dependency: DependenciesIdentifier.identifyDependencies(blob)) {
                    blob.addDependency(dependency);
                }

                presentBlobs.addBlob(blob);
            }
        }
    }
}
