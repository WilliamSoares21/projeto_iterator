
public class Client {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("=== Imprimindo usando Iterator (normal) ===");
        process(list);

        System.out.println("\n=== Removendo 'B' durante a iteração ===");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println("Visto: " + s);
            if (s.equals("B")) {
                System.out.println("Removendo " + s);
                it.remove();
            }
        }

        System.out.println("\nDepois da remoção:");
        process(list);

        System.out.println("\n=== Exemplo de erro: chamar remove() antes de next() ===");
        Iterator<String> it2 = list.iterator();
        try {
            it2.remove(); // deve lançar IllegalStateException
        } catch (IllegalStateException ex) {
            System.out.println("Capturado: " + ex.getMessage());
        }
    }

    public static <T> void process(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T item = it.next();
            System.out.println(item);
        }
    }
}
