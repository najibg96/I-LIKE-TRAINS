package skeleton;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;

/**
 * Game, keretosztály a játék működéséhez, stdout logoláshoz a teszteléshez
 */
public class Game {
	
	/** Filebaíráshoz szükséges objektum */
	static FileWriter fileWriter;
    
    /** Filebaíráshoz szükséges objektum */
    static BufferedWriter bufferedWriter;
    
    /** Filebaíráshoz szükséges objektum */
    static PrintWriter fileOut;

    /** Controller referencia */
    static Controller controller;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String args[]) throws InterruptedException{
		fileWriter = null;
		bufferedWriter = null;
		
		controller=new Controller();
		controller.startGame();
	}
	
	/**
	 * Generate filename.
	 *
	 * @param name the name
	 * @return the string
	 */
	public static String generateFilename(String name) {
		String FILENAME =System.getProperty("user.dir");
		if(name.contains(".txt")){
			FILENAME=FILENAME+"\\res\\test_inputs\\"+name;
		}
		else
			FILENAME=FILENAME+"\\res\\test_inputs\\"+name+".txt";
		return FILENAME;
	}
	
	/**
	 * Logolást és stdout-ra kiírást végző függvény
	 *
	 * @param s A log információ kiírása
	 */
	public synchronized static void log(String s){
        int testNum = controller.getTestNum();
		System.out.println(s);
		
		try {
			String FILENAME = System.getProperty("user.dir");
			File file = new File(FILENAME+"\\res\\test_logs\\test_log_"+testNum+".txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(s+"\n");

		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * Kiüríti a log output fájlját, hogy a következő teszteset kerülhessen bele
	 */
	public static void clearOutput(){
        int testNum = controller.getTestNum();

		try {
			String FILENAME = System.getProperty("user.dir");
			File file = new File(FILENAME+"\\res\\test_logs\\test_log_"+testNum+".txt");
			PrintWriter writer = new PrintWriter(file);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A teszteset stdoutputra logolt részét egy fájlbaírja és összehasonlítja 
	 * az előredefiniált helyes működést leíró outputtal.
	 * Ha minden egyezik, kiírja a stdoutputra az egyezést és a teszteset sikeres lefutását.
	 * Jöhet a következő teszteset.
	 */	
	public static void outputCompare(){
	    int testNum = controller.getTestNum();

		try {
			String FILENAME = System.getProperty("user.dir");
			List<String> f1 = Files.readAllLines(Paths.get(FILENAME+"\\res\\test_logs\\test_log_"+testNum+".txt"));
			List<String> f2 = Files.readAllLines(Paths.get(FILENAME+"\\res\\test_expected_logs\\test_log_"+testNum+".txt"));
			
			boolean flag = true;
			if(f1.size() != f2.size())
                flag = false;
            
            for(int i=0; i<f1.size() && flag; i++){
                if(!f1.get(i).equals(f2.get(i))){
                    flag = false;
                }
            }
			if (flag)
				System.out.println("[Test"+testNum+": SUCCESS]");
			else
				System.out.println("[Test"+testNum+": FAILED]");	
		} catch (IOException e) {
			System.out.println("Nem található a két összehasonlítandó fájl");
			e.printStackTrace();
		}
	}
}
