package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * MissingDependencies stores a collection of missing dependencies and the blobs that depend on them.
 */
public class MissingDependencies {
	private Map<String, Dependency> missingDependencies = new HashMap<>();

	public boolean containsDependency(Blob dependency) {
		if (missingDependencies.get(dependency) != null) {
			return true;
		}

		return false;
	}

	public void addDependentBlobToDependency(Blob dependentBlob, Blob dependency) {
		if (!containsDependency(dependency)) {
			addDependency(dependency);
		}

		Dependency pair = missingDependencies.get(dependency.getName());
		pair.addDependentBlob(dependentBlob);
	}

	public void addDependency(Blob dependency) {
		Dependency pairWithoutDependentBlobs = new Dependency(dependency);
		missingDependencies.putIfAbsent(dependency.getName(), pairWithoutDependentBlobs);
	}

	public List<Dependency> getMissingDependenciesAsList() {
		List<Dependency> missingDependenciesList = new ArrayList<>(missingDependencies.values());

		return missingDependenciesList;
	}

	public List<Blob> getDependentBlobsAsList(Blob dependency) {
		Dependency pair = missingDependencies.get(dependency.getName());
		List<Blob> dependentBlobs = pair.getDependentBlobs();
		return dependentBlobs;
	}
}
