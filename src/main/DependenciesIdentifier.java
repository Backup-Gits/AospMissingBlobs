package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * DependenciesIdentifier identifies the dependencies of a blob.
 */
public class DependenciesIdentifier {
    public static List<Blob> identifyDependencies(Blob blob) {
        List<Blob> dependencies = new ArrayList<>();

        /*
         * List blob dependencies using ldd-arm:
         * readelf -d $1 | grep "\(NEEDED\)" | sed -r "s/.*\[(.*)\]/\1/"
         */
        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("bash", "-c", "readelf -d " + blob.getFile().getAbsolutePath()
                    + " | grep \"\\(NEEDED\\)\" | sed -r \"s/.*\\[(.*)\\]/\\1/\"");

            final Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String dependencyName;
            while ((dependencyName = br.readLine()) != null) {
                Blob dependency = new Blob(dependencyName);
                dependencies.add(dependency);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return dependencies;
    }
}
