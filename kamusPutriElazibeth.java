import java.util.*;

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
