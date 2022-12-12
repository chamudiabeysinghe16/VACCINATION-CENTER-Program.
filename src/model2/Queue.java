package model2;
import exception.QueueEmptyException;
import exception.QueueFullException;
import java.util.Arrays;

public class Queue<QElement> {

    private int currentSize; //Current Circular Queue Size
    private QElement[] QueueElements;
    private int maxSize; //C Queue maximum size

    private int rear;//rear position of Circular queue(new element enqueued at rear).
    private int front; //front position of Circular queue(element will be dequeued from front).

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        QueueElements = (QElement[]) new Object[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }


    public void enqueue(QElement item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException(" Queue is full. Element cannot be added");
        } else {
            rear = (rear + 1) % QueueElements.length;
            QueueElements[rear] = item;
            currentSize++;

            if (front == -1) {
                front = rear;
            }
        }
    }
//Dequeue element from Front
    public QElement dequeue() throws QueueEmptyException {
        QElement deQueuedElement;
        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        } else {
            deQueuedElement = QueueElements[front];
            QueueElements[front] = null;
            front = (front + 1) % QueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }


    // Check if queue is full.

    public boolean isFull() {
        return (currentSize == QueueElements.length);
    }


    //Check if Queue is empty.

    public boolean isEmpty() {
        return (currentSize == 0);
    }
        @Override
        public String toString () {
            return "model.Queue [" + Arrays.toString(QueueElements) + "]";
        }

    }
