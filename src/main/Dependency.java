package main;

import java.util.ArrayList;
import java.util.List;

/*
 * Dependency stores a dependency and the blobs that depend on it.
 */
public class Dependency {
    private Blob dependency;
    private List<Blob> dependentBlobs = new ArrayList<>();

    Dependency(Blob dependency) {
        this.dependency = dependency;
    }

    public void addDependentBlob(Blob dependentBlob) {
        dependentBlobs.add(dependentBlob);
    }

    public Blob getDependency() {
        return dependency;
    }

    public List<Blob> getDependentBlobs() {
        return dependentBlobs;
    }
}
