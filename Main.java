public class Main {
    public static void main(String[] args) throws Exception {

        String data = "Your task is to find the smallest positive number";
        HuffmanCoder hf = new HuffmanCoder(data);

        String encoded = hf.encodeData(data);
        String decoded = hf.decodeData(encoded);

        System.out.println("Encoded :  " + encoded);
        System.out.println("Decoded :  " + decoded);

    }
}
