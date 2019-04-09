package main;

public class Main {
	public static void main(String[] args) {
		MissingBlobs b = new MissingBlobs();

		// Add each path to search for blobs
		for (String arg : args) {
			b.addBlobDir(arg);
		}

		b.updateMissingBlobs();
		b.showMissingBlobs();
	}
}
