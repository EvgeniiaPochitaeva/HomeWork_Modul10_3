package homeWork_Modul10_3;
import java.io.*;
import java.util.*;


public class Main  {
    private static final String myFail = "C:\\Users\\eshap\\IdeaProjects\\HomeWork_Modul10_3\\src\\words.txt";
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(myFail);
        checkIfFileAvailable(file);
        mySpisok(file);
    }
    private static void checkIfFileAvailable(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public static void mySpisok(File file) throws FileNotFoundException {
        FileInputStream fls = new FileInputStream(myFail);
        HashMap<String, Integer> spisok = new HashMap<>();
        Scanner scanner = new Scanner(fls);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");

            for (String word : words) {
                if (spisok.containsKey(word)) {
                    int count = spisok.get(word);
                    spisok.put(word, count + 1);
                } else {
                spisok.put(word, 1);
                }
            }
        }
             List<Map.Entry<String, Integer>> list = new ArrayList<>(spisok.entrySet());
             Comparator<Map.Entry<String, Integer>> sortComparator = (entry1, entry2) ->
                entry2.getValue().compareTo(entry1.getValue());
                    list.sort(sortComparator);

        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }


}



