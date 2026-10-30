public class LinkedQueue<T> implements QueueInterface<T> {
    private int size;
    private LLNode<T> elements;


      public int size() {
        return size;   
      }

    public boolean empty() {
        return size == 0;
    }
    public T add(T item) {
        LLNode<T> newNode = new LLNode<>(item);
        if (empty()) {
            elements = newNode;
        } else {
            LLNode<T> current = elements;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(newNode);
        }
        size++;
        return item;
    }
        

    public T peek() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return elements.getInfo();
    }
    
    
    public T remove() throws QueueUnderflowException {
        if (empty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        T item = elements.getInfo();
        elements = elements.getLink();
        size--;
        return item;
    }

    
    public void clear() {
        elements = null;
        size = 0;
    }
}
