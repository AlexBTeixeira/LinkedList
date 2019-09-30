public class DoubleLinkedListofInterger {
    private class Node {
        public Integer element;
        public Node next;
        public Node prev;


        public Node(Integer element) {
            this.element = element;
            next = null;
            prev = null;
        }
    }

    private Node header;
    private Node trailer;
    private int count =0;

    DoubleLinkedListofInterger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    private Node getRefNode(int index) {

        Node aux = null;
        if (index <= count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux;
    }

    void add(Integer element) {
        Node novo = new Node(element);

        //Setar o Nodo
        novo.next = trailer; // Indicador que fica fora da lista indicanco o ultimo elemento
        novo.prev = trailer.prev; // O seu anterior é o anterior do trailer

        //Setar o trailer
        trailer.prev.next = novo; // Liga o nodo que estava antes do trailer
        trailer.prev = novo; //Ultimo elemento agora é o current;
        count++;

    }

    void add(Integer element, Integer index) {

        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node novo = new Node(element);

        if (index == 0) {
            novo.prev = header;
            header.next = novo;
            novo.next = trailer;
            trailer.prev = novo;

        } else if (index == count) {

            novo.next = trailer;
            trailer.prev = novo;
            trailer.prev.next = novo;
            novo.prev = trailer.next.prev;

        } else {
            Node current = header;
            for (int i = 0; i < count; i++) {
                current = current.next;
                if (i == index) {
                    novo.prev = current.prev;
                    novo.next = current.prev.next;
                    current.prev.next = novo;
                    current.prev = novo;
                }
            }
        }

        count++;
    }

    public Integer get(int index) {

        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getRefNode(index);
        return aux.element;
    }

    void set(Integer index, Integer element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node novo = new Node(element);
        Node current = header;
        for (int i = 0; i < count; i++) {
            current = current.next;
            if (i == index) {
                current.element = element;
            }
        }
    }

    public boolean remove(Integer element) {
        Node current = header;
        for (int i = 0; i < count; i++) {
            current = current.next;
            if((current.element).equals(element)){
                current.next.prev = current.prev;
                current.prev.next = current.next;
                return true;
            }

        }
        return false;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getRefNode(index);

        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
    }

    public boolean isEmpty() {
        if (header == null && trailer == null && count == 0) {
            return true;
        } else return false;
    }

    public boolean contains(int element) {
        Node novo = new Node(element);
        Node current = header;
        for (int i = 0; i < count; i++) {
            current = current.next;
            if ((current.element) == element) {
                return true;
            }
        }
        return false;
    }

    public Integer indexOf(Integer element) {
        Node current = header;
        for (int i = 0; i < count; i++) {
            current = current.next;
            if ((current.element) == element) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        count = 0;
        header = null;
        trailer = null;

    }

    public Integer size() {
        return count;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        Node aux = header.next;

        for(int i =0; i<count;i++){
            s.append(aux.element.toString());
            s.append("\n");
            aux =aux.next;
        }
        return s.toString();
    }

    public String toStringBackToFront() {
        StringBuilder s = new StringBuilder();
        Node aux = trailer.prev;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.prev;
        }
        return s.toString();
    }

    void reverse(){

        Node current = header;
        Node temp = null;

        while(current!=null){

            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.next;
        }

    }

    public void unique(){
        for(int i = 0; i<count; i++){
            int num = get(i);
            for( int j = i+1; j< count;j++){
                if(num == get(j)){
                        removeByIndex(j);
                }
            }
        }
    }
}
