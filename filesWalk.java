import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class filesWalk {
	
	private static void unZIP(String folderPath, String zipPath) {

		// buffer for read and write data to file
		byte[] buffer = new byte[2048];
		try {
			FileInputStream fInput = new FileInputStream(zipPath);
			ZipInputStream zipInput = new ZipInputStream(fInput);
			ZipEntry entry = zipInput.getNextEntry();
			while(entry != null){
			String entryName = entry.getName();
			System.out.println("Unzip file " + entryName + " to " + folderPath);
	
			String[] array = entryName.split("\\/");
			String path = "";
	
			for(int i=0; i<array.length-1; i++)
			{
				path +=array[i]+"\\";
			}
			File directory = new File(folderPath + File.separator + path);
			// if the output directory doesn't exist, create it
			if(!directory.exists())
			{
				directory.mkdirs();
			}
			FileOutputStream fOutput = new FileOutputStream(folderPath + File.separator + entryName);
			int count = 0;
			while ((count = zipInput.read(buffer)) > 0) {
				// write 'count' bytes to the file output stream
				fOutput.write(buffer, 0, count);
			}
	
			fOutput.close();
	
			// close ZipEntry and take the next on
			zipInput.closeEntry();
	
			entry = zipInput.getNextEntry();
	
			}
			// close the last ZipEntry
			zipInput.closeEntry();
			zipInput.close();
			fInput.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean checkWords(Path filename) {
		String word1 = "volatile";
		String word2 = "transient";
		boolean vol = false;
		boolean trans = false;
		try {
			File f = new File(String.valueOf(filename));
			FileReader is = new FileReader(f);
			BufferedReader br = new BufferedReader(is);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.toLowerCase().contains(word1.toLowerCase()))
					vol = true;
				if (line.toLowerCase().contains(word2.toLowerCase()))
					trans = true;
				if (vol && trans) {
					is.close();
					br.close();
					return true;
				}
			}
			is.close();
			br.close();

		} catch (IOException e) {
			System.out.println("Error of path " + e);
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ZIP_PATH = "C:\\Users\\Ira\\Desktop\\JavaTasks\\src.zip";
		String FOLDER_PATH = "C:\\Users\\Ira\\Desktop\\JavaTasks\\srczip";
		//unZIP(FOLDER_PATH, ZIP_PATH);
		try {
			Files.walk(Paths.get("srczip/")).filter(p -> p.toString().endsWith(".java")).filter((p) -> checkWords(p)).forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("Error of path " + e);
		}

	}

}
