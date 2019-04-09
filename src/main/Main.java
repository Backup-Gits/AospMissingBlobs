package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<File> blobDirectories = getFileListFromArgs(args);

		BlobGroup presentBlobs = new BlobGroup();
		PresentBlobsFinder presentBlobsFinder = new PresentBlobsFinder();
		presentBlobsFinder.findBlobsInDirectories(blobDirectories, presentBlobs);

		MissingDependencies missingDependencies = new MissingDependencies();
		MissingDependenciesFinder missingDependenciesFinder = new MissingDependenciesFinder();
		missingDependenciesFinder.findMissingDependencies(presentBlobs, missingDependencies);

		MissingDependenciesReporter reporter = new MissingDependenciesReporter();
		reporter.reportMissingDependenciesAndDependentBlobs(missingDependencies);
	}

	private static List<File> getFileListFromArgs(String[] directoryNames) {
		List<File> blobDirectories = new ArrayList<>();
		for (String directoryName : directoryNames) {
			File directory = new File(directoryName);
			blobDirectories.add(directory);
		}
		return blobDirectories;
	}
}
