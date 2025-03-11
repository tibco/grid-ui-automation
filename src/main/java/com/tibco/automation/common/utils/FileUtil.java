package com.tibco.automation.common.utils;

/**
 * Common file utility methods extended from org.apache.commons.io.FileUtils.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Random;
import java.util.Vector;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class FileUtil extends FileUtils {
	private static int counter = -1; /* Protected by tmpFileLock */

	public static String saveImageFile(String base64Str, String prefix, String dir) throws Exception {
		byte[] decodedScreenshot = Base64.decodeBase64(base64Str.getBytes());// new
		// Base64Encoder().decode(base64Str);
		File file = generateFile(prefix, ".png", dir);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(decodedScreenshot);
		fos.close();
		return file.getName();
	}

	public static String saveImageFile(BufferedImage bImag, String prefix, String dir) throws Exception {
		// Base64Encoder().decode(base64Str);
		File file = generateFile(prefix, ".png", dir);
		ImageIO.write(bImag, "png", file);
		return file.getName();
	}

	public static String getContentType(File f) {
		MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String ct = fileNameMap.getContentTypeFor(f.getName());
		return StringUtil.isBlank(ct) ? fileTypeMap.getContentType(f) : ct;
	}

	/**
	 * Check and Create a directory if not exist; all non-existent ancestor
	 * directories will automatically created
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean checkCreateDir(String dir) {
		File tdir = new File(dir);
		boolean dirExists = tdir.exists();
		if (!dirExists) {
			dirExists = tdir.mkdirs();
		}
		return dirExists;
	}

	/**
	 * Method to get relative file path Ex: String filePath =
	 * "/var/data/images/xyz.png"; String root = "/var/data"; return value will
	 * be "images/xyz.png"
	 * 
	 * @param root
	 * @param filePath
	 * @return
	 */
	public static String getReletivePath(String root, String filePath) {
		String relative = new File(root).toURI().relativize(new File(filePath).toURI()).getPath();
		return relative;
	}

	public static File generateFile(String prefix, String suffix, String dir) throws IOException {
		if (counter == -1) {
			counter = new Random().nextInt() & 0xffff;
		}
		counter++;
		return new File(dir, prefix + Integer.toString(counter) + suffix);
	}

	public static File[] listFilesAsArray(File directory, FilenameFilter filter, boolean recurse) {
		Collection<File> files = listFiles(directory, filter, recurse);
		File[] arr = new File[files.size()];
		return files.toArray(arr);
	}

	public static Collection<File> listFiles(File directory, String fname, StringComparator c, boolean recurse) {
		return listFiles(directory, getFileFilterFor(fname, c), recurse);
	}

	public static File[] listFilesAsArray(File directory, String fname, StringComparator c, boolean recurse) {
		Collection<File> files = listFiles(directory, fname, c, recurse);
		File[] arr = new File[files.size()];
		return files.toArray(arr);
	}

	public static Collection<File> listFiles(File directory, FilenameFilter filter, boolean recurse) {
		// List of files / directories
		Vector<File> files = new Vector<File>();

		// Get files / directories in the directory
		File[] entries = directory.listFiles();

		// Go over entries
		for (File entry : entries) {
			if ((filter == null) || filter.accept(directory, entry.getName())) {
				files.add(entry);
			}

			// If the file is a directory and the recurse flag
			// is set, recurse into the directory
			if (recurse && entry.isDirectory()) {
				files.addAll(listFiles(entry, filter, recurse));
			}
		}

		// Return collection of files
		return files;
	}

	public static String getBase64String(File f) throws IOException {

		return new String(Base64.encodeBase64(readFileToByteArray(f)));
	}


	/**
	 * @param fname
	 *            : file name or part of file name to search
	 * @param comparator
	 *            : comparator to use while filtering file.
	 * @return: FilenameFilter Example:
	 *          <ol>
	 *          <li>getFileFilterFor(".properties", StringComparator.Suffix)
	 *          <li>getFileFilterFor("TC123", StringComparator.Prefix)
	 *          <li>getFileFilterFor("TC123.*.png", StringComparator.RegExp)
	 *          </ol>
	 */
	public static FilenameFilter getFileFilterFor(final String fname, StringComparator comparator) {
		final StringComparator fnamecomparator = null != comparator ? comparator : StringComparator.In;
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return fnamecomparator.compareIgnoreCase(name, fname);
			}
		};

		return filter;
	}

	public static FilenameFilter getFileFilterFor(final String name) {
		return getFileFilterFor(name, null);
	}

	
	public static Collection<File> getFiles(File directory, String extension, boolean recurse) {
		// List of files / directories
		Vector<File> files = new Vector<File>();

		// Get files / directories in the directory
		File[] entries = directory.listFiles();
		FilenameFilter filter = getFileFilterFor(extension);
		// Go over entries
		for (File entry : entries) {
			if ((filter == null) || filter.accept(directory, entry.getName())) {
				files.add(entry);
			}

			// If the file is a directory and the recurse flag
			// is set, recurse into the directory
			if (recurse && entry.isDirectory()) {
				files.addAll(listFiles(entry, filter, recurse));
			}
		}

		// Return collection of files
		return files;
	}

	public static Collection<File> getFiles(File directory, String name, StringComparator c, boolean recurse) {
		// List of files / directories
		Vector<File> files = new Vector<File>();

		// Get files / directories in the directory
		File[] entries = directory.listFiles();
		FilenameFilter filter = getFileFilterFor(name, c);
		// Go over entries
		for (File entry : entries) {
			if ((filter == null) || filter.accept(directory, entry.getName())) {
				files.add(entry);
			}

			// If the file is a directory and the recurse flag
			// is set, recurse into the directory
			if (recurse && entry.isDirectory()) {
				files.addAll(listFiles(entry, filter, recurse));
			}
		}

		// Return collection of files
		return files;
	}

	/**
	 * @param fname
	 *            : (optional) filename and file extension as two separate args
	 *            or file name with extension..
	 * @return
	 * @throws IOException
	 */
	public static File createTempFile(String... fname) throws IOException {
		return createTempFile(null, fname);
	}

	public static File createTempFile(File dir, String... name) throws IOException {
		String fname = null, ext = null;
		if ((name != null)) {
			if ((name.length == 1) && StringUtil.isNotEmpty(name[0])) {
				// check contains extension?
				int dotSign = name[0].lastIndexOf(".");
				if ((dotSign >= 0) && (dotSign < name[0].length())) {
					fname = name[0].substring(0, dotSign);
					ext = name[0].substring(dotSign);
				} else {
					fname = name[0];
				}
			} else if (name.length > 1) {
				fname = name[0];
				ext = name[1].startsWith(".") ? name[1] : "." + name[1];
			}
		}
		if (StringUtil.isBlank(fname)) {
			fname = StringUtil.createRandomString("Auto");
		}
		File tmpfile = File.createTempFile(fname, ext, dir);
		tmpfile.deleteOnExit();
		return tmpfile;
	}

	public static void main(String[] args) {
		String s = "test123.property";
		System.out.println(StringComparator.In.compare(s, ".proper"));
		System.out.println(StringComparator.RegExp.compareIgnoreCase("Test123aaa.png", "test123.*.png"));
		
		System.out.println(FileUtil.getContentType(new File("test.doc")));
		Vector<File> list = (Vector<File>) FileUtil.getFiles(new File("."), "selenium-server.*\\.jar",
				StringComparator.RegExp, true);
		System.out.println("found " + list.size() + " selenium server");
		File serverJar = (list == null) || list.isEmpty() ? new File("./server/selenium-server*.jar") : list.get(0);
		if (serverJar.exists()) {

			System.out.println("java -jar \"" + serverJar.getAbsolutePath() + "\"");
		}

	}

}
