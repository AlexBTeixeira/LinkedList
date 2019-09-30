public class LinkedListOfInterger {

    private class Node {
        private int element;
        public Node next;

        public Node(int element) {
            this.element = element;
            this.next = null;
        }

    }

    private Node Head;
    private Node Tail;
    private int count;

    LinkedListOfInterger() {//Cria uma lista vazia
        Head = null;
        Tail = null;
        count = 0;

    }

    void add(int element) {
        Node aux = new Node(element);

        if (Head == null) {
            Head = aux;
        }//Se a lista estiver vazia
        else {
            Tail.next = aux;
        }// Se a lista ja tiver elementos

        Tail = aux; //Atualiza o valor do Tail
        count++; //Incrementa a contagem de elementos

    }

    void add(int element, int index) {

        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        } // Se  index for invalido

        Node aux = new Node(element);
        Node current = Head;

        if (index == 0) {
            aux.next = Head; //Conecta na Lista
            Head = aux;
        }//Transforma o Head
        else if (index == count) {

            Tail.next = aux; //Conecta na Lista
            Tail = aux;//Transforma o Head
        } else {
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            aux.next = current.next;
            current.next = aux;
        }
        count++;
    }

    int get(int index) {
        Node Current = Head;

        int count = 0;
        while (Current != null) {
            if (count == index) {
                return Current.element;
            }

            count++;
            Current = Current.next;
        }


        return 0;
    }

    int set(int element, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        } // Se index for invalido

        Node Current = Head;

        for (int i = 0; i < index; i++) {
            Current = Current.next;
        }
        int temp = Current.element;
        Current.element = element;
        return temp;
    }

    private int indexOf(int element) {
        Node Current = Head;
        int index = 0;

        // for (int i =0; i<count; i++){
        //      int aux = Current.element;
        //    if ((Current.element)==(element)){
        //      return i;
        //}
        //}

        while (Current != null) {
            if ((Current.element) == (element)) {
                return index;
            }
            Current = Current.next;
            index++;
        }
        return -1;
    }

    public boolean remove(Integer element) {
        Node Current = Head.next;
        Node ant = Head;
        if (element == null || count == 0) {
            return false;
        }
        if ((Head.element) == element) {
            Head = Head.next;
            if (count == 1) {
                Tail = null;
            }
            count--;
            return true;
        }// Se o elemento for o Head

        for (int i = 0; i < count; i++) {
            if ((Current.element) == element) {
                if (Current == Tail) {
                    Tail = ant;
                    Tail.next = null;
                } else {
                    ant.next = Current.next;
                }
                count--;
                return true;
            }
            ant = ant.next;
            Current = Current.next;
        }
        return false;
    }

    void removeByIndex(int Index) {
        Node Current = Head;
        if (Index < 0 || Index > count) {
            throw new IndexOutOfBoundsException();
        }

        if (Index == 0) {
            if (Tail == Head) {
                Tail = null;
            }
            Head = Head.next;
            count--;
            return;
        }

        int aux = 0;
        while (aux < Index - 1) {
            Current = Current.next;
            aux++;
        }
        if (Tail == Current.next) {
            Tail = Current;
        }
        Current.next = Current.next.next;
        count--;
    }

    boolean isEmpty() {
        if (count != 0 && Head != null) {
            return false;
        }
        return true;
    }

    int size() {
        return count;
    }

    boolean contains(int element) {
        Node current = Head;

        if (indexOf(element) != -1) {
            return true;
        } else return false;
    }

    void clear() {
        Head = null;
        Tail = null;
        count = 0;
    }

    int[] getBackToFront() {
        int[] v = new int[count];
        getBackToFront(Head, v, count - 1);
        return v;
    }

    private void getBackToFront(Node n, int[] v, int i) {
        if (n != null) {
            getBackToFront(n.next, v, i - 1);
        }

    }

    boolean addAfter(int element, int element2) {
        Node Current = Head;
        Node n = new Node(element2);
        while (Current != null) {
            if ((element) == Current.element) {
                n.next = Current.next;
                Current.next = n;
                count++;
                if (Current == Tail) {
                    n = Tail;
                    return true;
                }
            }
            Current = Current.next;
        }
        return false;
    }

    boolean equals(LinkedListOfInterger other) {
        if (count != other.count) {
            return false;
        }
        Node Current = Head;
        Node CurrentOther = other.Head;

        for (int i = 0; i < count; i++) {
            if ((Current.element) != (CurrentOther.element)) {
                return false;
            }
            Current = Current.next;
            CurrentOther = CurrentOther.next;
        }
        return true;
    }

    LinkedListOfInterger getRepetidos(LinkedListOfInterger Li) {

        LinkedListOfInterger novaLista = new LinkedListOfInterger();
        for (int i = 0; i < count; i++) {// Passa por todas as posições da Lista
            int num = Li.get(i); // Pega o termo
            for (int j = i + 1; i < Li.size(); j++) // Passa por todas as posições a partir de i+1
                if (Li.get(j) == num) { //Compara os termos
                    if (!novaLista.contains(num)) {// Se a nova lista ainda não tem o numero
                        novaLista.add(num);
                    } //Adiciona o numero repetifo
                }
        }
        return novaLista;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = Head;

        while (aux != null) {
            s.append(aux.element);
            s.append("\n");
            aux = aux.next;

        }
        return s.toString();
    }

}


