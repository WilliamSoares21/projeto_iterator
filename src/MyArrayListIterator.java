import java.util.NoSuchElementException;

public class MyArrayListIterator<T> implements Iterator<T> {
    private final MyArrayList<T> list;
    private int cursor = 0;    // índice do próximo a retornar
    private int lastRet = -1;  // índice do último retornado (para remove)

    public MyArrayListIterator(MyArrayList<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor < list.size();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        lastRet = cursor;
        T e = list.get(cursor);
        cursor++;
        return e;
    }

    @Override
    public void remove() {
        if (lastRet < 0) throw new IllegalStateException("remove() só pode ser chamado após next()");
        list.remove(lastRet);
        // ajusta o cursor porque a lista encolheu
        cursor = lastRet;
        lastRet = -1;
    }
}
