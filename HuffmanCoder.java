import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoder {
    HashMap<Character ,String>  encoder ;
    HashMap<String , Character> decoder ;

    private class Node implements Comparable<Node> {
        Character data;
        int cost;
        Node left;
        Node right;

        public  Node(Character data , int cost){
            this.data =  data;
            this.cost = cost;

            this.left = this.right = null;
        }

        @Override
        public  int compareTo(Node other){
            return this.cost = other.cost;
        }


    }

    public HuffmanCoder(String feeder) throws Exception{
        HashMap<Character , Integer> freq = new HashMap<>();

        for(char ch : feeder.toCharArray()){
            freq.put(ch , freq.getOrDefault(ch , 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(char ch : freq.keySet()){
            Node temp = new Node(ch , freq.get(ch));

            pq.offer(temp);
        }

        while(pq.size() > 1){
            Node first = pq.poll();
            Node second = pq.poll();

            Node temp = new Node('\0' , first.cost+ second.cost);

            temp.left = first;
            temp.right = second;

            pq.offer(temp);
        }

        Node complete = pq.poll();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initilize(complete , "");
    }

    private void initilize(Node curr, String str) {
        if(curr == null)    return;

        if(curr.left == null && curr.right == null) {
            encoder.put(curr.data , str);
            decoder.put(str , curr.data);
            return;
        }

        initilize(curr.left , str+"0");
        initilize(curr.right , str+"1");
    }

    public String encodeData(String str){
        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()){
            sb.append(encoder.get(ch));
        }

        return sb.toString();
    }

    public String decodeData(String str){
        StringBuilder sb = new StringBuilder();

        StringBuilder key = new StringBuilder();

        for(char ch : str.toCharArray()){
            key.append(ch);

            if(decoder.containsKey(key.toString())){
                sb.append(decoder.get(key.toString()));
                key = new StringBuilder();
            }
        }

        return sb.toString();
    }
}
