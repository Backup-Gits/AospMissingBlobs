package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Blob stores information about the blob, including its dependencies.
 */
public class Blob {
	private String name;
	private File file;
	private Map<String, Blob> dependencies = new HashMap<>();

	public Blob(String name) {
		this.name = name;
	}

	public Blob(File file) {
		this.file = file;
		this.name = file.getName();
	}

	public File getFile() {
		return file;
	}

	public String getName() {
		return name;
	}

	public void addDependency(Blob blob) {
		dependencies.putIfAbsent(blob.getName(), blob);
	}

	protected boolean containsDependency(Blob blob) {
		return dependencies.containsKey(blob.getName());
	}

	public List<Blob> getDependenciesList() {
		List<Blob> dependenciesList = new ArrayList<>(dependencies.values());
		return dependenciesList;
	}
}
