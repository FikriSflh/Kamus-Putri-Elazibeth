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
