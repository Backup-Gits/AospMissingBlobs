package main;

/*
 * MissingDependenciesFinder generates a list of missing dependencies
 */
public class MissingDependenciesFinder {
    public void findMissingDependencies(BlobGroup presentBlobs, MissingDependencies missingDependencies) {
        for (Blob presentBlob: presentBlobs.getPresentBlobsList()) {
            for (Blob dependency: presentBlob.getDependenciesList()) {
                if (missingDependencies.containsDependency(dependency)) {
                    missingDependencies.addDependentBlobToDependency(presentBlob, dependency);
                } else {
                    if (presentBlobs.containsBlob(dependency)) {
                        continue;
                    } else {
                        missingDependencies.addDependency(dependency);
                        missingDependencies.addDependentBlobToDependency(presentBlob, dependency);
                    }
                }
            }
        }
    }
}
