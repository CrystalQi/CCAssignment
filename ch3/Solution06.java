package ch3;
import java.util.*;

/**
 * ch3.06 Animal Shelter
 * @author qxia
 *
 */
public class Solution06 {
	enum AnimalType {CAT, DOG}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalShelter as = new AnimalShelter();
		as.enqueue(new Animal("Tom", AnimalType.CAT));
		as.enqueue(new Animal("Carnegie", AnimalType.DOG));
		as.enqueue(new Animal("Mellon", AnimalType.DOG));
		as.enqueue(new Animal("Bella", AnimalType.CAT));
		as.enqueue(new Animal("Kitty", AnimalType.CAT));
		as.enqueue(new Animal("WANGCAI", AnimalType.DOG));
		
		System.out.println("Adopt a dog: "+as.dequeueDog().name);
		System.out.println("Adopt any: "+as.dequeueAny().name);
		System.out.println("Adopt a cat: "+as.dequeueCat().name);
	}
	
	public static class AnimalShelter {
		
		
		private LinkedList<Animal> waitingList;
		
		public AnimalShelter(){
			waitingList = new LinkedList<Animal>();
		}
		
		public void enqueue(Animal animal){
			waitingList.add(animal);
		}
		
		public Animal dequeueAny(){
			if(waitingList.isEmpty()){
				return null;
			}
			else{
				return waitingList.remove();
			}
		}
		
		public Animal dequeueDog(){
			if(waitingList.isEmpty()){
				return null;
			}
			if(waitingList.peek().type == AnimalType.DOG){
				return waitingList.remove();
			}
			else{
				Stack<Animal> tmp = new Stack<Animal>();
				while(!waitingList.isEmpty()&& waitingList.peek().type==AnimalType.CAT){
					tmp.push(waitingList.remove());
				}
				if(waitingList.isEmpty()){
					return null;
				}
				
				Animal toAdopt = waitingList.remove();
				while(!tmp.isEmpty()){
					waitingList.addFirst(tmp.pop());
				}
				return toAdopt;
			}
		}
		
		public Animal dequeueCat(){
			if(waitingList.isEmpty()){
				return null;
			}
			if(waitingList.peek().type == AnimalType.CAT){
				return waitingList.remove();
			}
			else{
				Stack<Animal> tmp = new Stack<Animal>();
				while(!waitingList.isEmpty()&& waitingList.peek().type==AnimalType.DOG){
					tmp.push(waitingList.remove());
				}
				if(waitingList.isEmpty()){
					return null;
				}
				
				Animal toAdopt = waitingList.remove();
				while(!tmp.isEmpty()){
					waitingList.addFirst(tmp.pop());
				}
				return toAdopt;
			}			
		}
	}
	
	public static class Animal{
		String name;
		AnimalType type;
		
		public Animal(String name, AnimalType type) {
			this.name = name;
			this.type = type;
		}
	}

}
