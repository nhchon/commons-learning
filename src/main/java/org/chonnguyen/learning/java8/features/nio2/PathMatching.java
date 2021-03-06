// PathMatching.java
package org.chonnguyen.learning.java8.features.nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatching {
	public static void main(String[] args) {
		String globPattern = "glob:**txt";
		PathMatcher matcher = 
			FileSystems.getDefault().getPathMatcher(globPattern);
		Path path = Paths.get("C:\\poems\\luci1.txt");
		boolean matched = matcher.matches(path);
		System.out.format("%s matches %s: %b%n", 
		                  globPattern, path, matched);
	}
}
