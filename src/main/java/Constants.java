
//
//public class Constants {
//		
//		public static String TopicName = "zzz64";
//
//	
//	}

import java.io.*;

public class Constants {
    public static String TopicName = "zzz" + getAndUpdateTopicCounter();

    private static int getAndUpdateTopicCounter() {
        File file = new File("topic_counter.txt");
        int number = 0;

        try {
            // Read the current value (or create if file doesn't exist)
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                fw.write("1");
                fw.close();
                return 1;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            br.close();

            number = (line != null && !line.isEmpty()) ? Integer.parseInt(line) : 1;

            // Write back incremented value
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(String.valueOf(number + 1));
            bw.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error handling topic_counter.txt: " + e.getMessage());
        }

        return number;
    }
}
