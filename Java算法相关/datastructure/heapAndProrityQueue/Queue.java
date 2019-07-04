package datastructure.heapAndProrityQueue;

public interface Queue<E>
{

	int getSize();

	boolean isEmpty();

	void enqueue(E e);

	E dequeue();

	E getFront();
}
