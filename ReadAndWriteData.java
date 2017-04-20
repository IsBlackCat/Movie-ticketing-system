package traning2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteData {

	public static void write(List<Movie> movies) throws Exception {
		File dir = new File(".\\bin\\traning2\\movieData");
		if(dir != null) {
			File[] files = dir.listFiles();
			for(int i = 0; i < files.length; i++) {
				files[i].delete();
			}
			int n = movies.size();
			for(int i = 0; i < n; i++) {
				File f = new File(".\\bin\\traning2\\movieData\\"+i+".txt");
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
				movies.get(i).getMovie(bw);
			}
		}
	}
	
	public static void text() {
		File dir = new File(".\\bin\\traning2\\movieData\\abc.txt");
		try {
			dir.createNewFile();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir)));
			bw.write("lsdkfjskfl");
			bw.flush();
			bw.close();
			if(dir.exists())
				dir.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void read(List<Movie> movies) throws Exception {
		File dir = new File(".\\bin\\traning2\\movieData");
		if(dir != null) {
			File[] files = dir.listFiles();
			for(int i = 0; i < files.length; i++) {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(files[i])));
				Movie m = new Movie();
				m.setMovie(br);
				movies.add(m);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			ReadAndWriteData.text();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
