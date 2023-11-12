package mapa.rutas;
import java.util.*;

public class pq {
//	Queue<Integer> queueL = new LinkedList<>();
//    for (int i = 5; i > 0; i--) {
//        queueL.add(i);
//    }
//    System.out.println("LinkedList Queue (FIFO): " + queueL);
//    Queue<Integer> priorityQueue = new PriorityQueue<>();
//
//    for (int i = 5; i > 0; i--) {
//    priorityQueue.offer(i);
//    }
//    System.out.println("PriorityQueue: " + priorityQueue)
	
	 public static void main2(String[] args) {
			Queue<Integer> queueL = new LinkedList<>();
	    for (int i = 5; i > 0; i--) {
	        queueL.add(i);
	    }
	    System.out.println("LinkedList Queue (FIFO): " + queueL);
	    Queue<Integer> priorityQueue = new PriorityQueue<>();
	
	    for (int i = 5; i > 0; i--) {
	    priorityQueue.offer(i);
	    }
	    System.out.println("PriorityQueue: " + priorityQueue);	 
	 }
	 
	   public static void main(String args[]) { // cola con capacitad de 11
	        PriorityQueue<Double> cola = new PriorityQueue<Double>();
	        cola.offer(3.2);
	        cola.offer(9.8);
	        cola.offer(5.4);
	        System.out.print("Mostrando la cola: ");
	        while(cola.size() > 0) {
	            System.out.printf("%.1f ", cola.peek());
	            cola.poll();
	        }
	    }
}
