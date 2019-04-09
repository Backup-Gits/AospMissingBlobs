package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * BlobGroup stores a collection of blobs.
 */
public class BlobGroup {
    private Map<String, Blob> blobs = new HashMap<>();

    public void addBlob(Blob blob) {
        blobs.put(blob.getName(), blob);
    }

    public boolean containsBlob(Blob blob) {
        if (blobs.containsKey(blob.getName())) {
            return true;
        }

        return false;
    }

    public List<Blob> getPresentBlobsList() {
        List<Blob> presentBlobsList = new ArrayList<>(blobs.values());
        return presentBlobsList;
    }
}
