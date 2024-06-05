import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class kamusPutriElazibeth {

    public static class HashTable {
        private final int size;
        private final ArrayList<String>[] table;

        
        public HashTable(int size) {
            this.size = size;
            this.table = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                table[i] = new ArrayList<>();
            }
        }
    private int hashFunction(String kata) {
            int hash = 0;
            for (int i = 0; i < kata.length(); i++) {
                char ch = kata.charAt(i);
                int asciiValue = (int) ch;
                hash = (hash * 31 + asciiValue) & 0xFFFFFFFF;
            }
            return Math.abs(hash) % size;
        }       
    public void insert(String kata) {
            int hashedKata = hashFunction(kata);
            ArrayList<String> bucket = table[hashedKata];
            if (!bucket.contains(kata)) {
                bucket.add(kata);
            }
        }
    public ArrayList<String> temukanKata() {
            ArrayList<String> sekata = new ArrayList<>();
            for (ArrayList<String> bucket : table) {
                sekata.addAll(bucket);
            }
            return sekata;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan paragraf:");
        String inputText = sc.nextLine();

        inputText = inputText.toLowerCase();

        Pattern pattern = Pattern.compile("\\b[a-z]+\\b");
        Matcher matcher = pattern.matcher(inputText);

        HashTable hashTable = new HashTable(5000);

        while (matcher.find()) {
            String word = matcher.group();
            hashTable.insert(word);
        }
    ArrayList<String> kataUnik = hashTable.temukanKata();
        Collections.sort(kataUnik);

        for (String word : kataUnik) {
            System.out.println(word);
        }

        sc.close();
    }
}
