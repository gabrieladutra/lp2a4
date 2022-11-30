package github1;

public class ThreadPrincipal extends Thread {
	public void run() {
		System.out.println("Nova Thread: " + this.getName());
		System.out.println("Maria");
		decremento();
	}
	
	public static  void decremento() {
		int contador = -1;
		while(contador >-100) {
			contador--;
			System.out.println(contador);
		}
	}
	
	public static void incremento() {
		int contador = 0;
		while(contador < 100) {
			contador++;
			System.out.println(contador);
		}
	}

}
