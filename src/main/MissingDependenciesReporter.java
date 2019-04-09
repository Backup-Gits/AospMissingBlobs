package main;

import java.util.List;

/*
 * MissingDependenciesReporter prints formatted report of missing dependencies and the blobs that depend on them.
 */
public class MissingDependenciesReporter {
    public void reportMissingDependenciesAndDependentBlobs(MissingDependencies missingDependencies) {
        List<Dependency> missingDependenciesList = missingDependencies.getMissingDependenciesAsList();
        for (Dependency missingDependency: missingDependenciesList) {
            printMissingDependencyAndDependentBlobs(missingDependency);
        }
    }

    private void printMissingDependencyAndDependentBlobs(Dependency missingDependency) {
        System.out.println(missingDependency.getDependency().getName() + ":" + getBlobListAsString(missingDependency.getDependentBlobs()));
    }

    private String getBlobListAsString(List<Blob> blobs) {
        StringBuilder blobsString = new StringBuilder();
        for (Blob blob : blobs) {
            blobsString.append(" " + blob.getName());
        }

        return blobsString.toString();
    }
}
