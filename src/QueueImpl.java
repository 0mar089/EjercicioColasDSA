public class QueueImpl<E> implements Queue<E>{
    private E[] data;
    private int p;

    public QueueImpl(int len) {
        this.data = (E[])new Object[len];
    }

    public void push(E e) throws FullQueueException {
        if (isFull()) throw new FullQueueException();
        else{
            data[p] = e;
        }

        this.data[this.p++]=e;

    }


    public E pop() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        else{
            E q = data[0];
            for(int i = 0; i < this.p - 1; i++){
                data[i] = data[i + 1];
            }
            data[--p] = null; 
            return q;

        }
    }

    private boolean isFull() {
        return p >= data.length;
    }

    private boolean isEmpty() {
        return p == 0;
    }

    public int size() {
        return this.p;
    }
}
