package datastructure.queue.test;

public interface Queue<E>
{

	int getSize();

	boolean isEmpty();

	void enqueue(E e);

	E dequeue();

	E getFront();
}
