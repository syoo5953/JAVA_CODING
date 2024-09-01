public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // 리스트의 처음에 노드 추가
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // 리스트의 끝에 노드 추가
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // 리스트의 기본 추가 메소드 (끝에 추가)
    public void add(int data) {
        addLast(data); // 기본적으로 리스트 끝에 추가
    }

    // 리스트의 처음 노드 제거
    public void removeFirst() {
        if (head == null) {
            return; // 리스트가 비어 있음
        }
        if (head == tail) { // 리스트에 노드가 하나만 있는 경우
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // 리스트의 끝 노드 제거
    public void removeLast() {
        if (tail == null) {
            return; // 리스트가 비어 있음
        }
        if (head == tail) { // 리스트에 노드가 하나만 있는 경우
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // 리스트에서 특정 데이터 제거
    public void remove(int data) {
        if (head == null)
            return;

        if (head.data == data) {
            removeFirst();
            return;
        }

        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            // 만약 tail이 삭제되었다면 tail을 업데이트
            if (current == tail) {
                tail = current.prev;
            }
        }
    }

    // 리스트 출력
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.printList(); // 출력: 1 2 3 4

        list.removeFirst();
        list.printList(); // 출력: 2 3 4

        list.removeLast();
        list.printList(); // 출력: 2 3

        list.add(5);
        list.printList(); // 출력: 2 3 5

        list.remove(3);
        list.printList(); // 출력: 2 5
    }
}