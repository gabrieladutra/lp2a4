package github1;


public class RunnableImplementacao implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Thread: " + Thread.currentThread().getName());
		ThreadPrincipal.incremento();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("A Thread está sendo executada: " + Thread.currentThread().getName());
		Runnable runnable = new RunnableImplementacao();
		Thread thread1 = new Thread(runnable);
		thread1.start();
		thread1.sleep(5000);
		Thread thread2 = new ThreadPrincipal();
		thread2.start();
		System.out.println("O Join aparecerá em breve...");
		Thread thread3 = new Thread(() -> System.out.println("Outra Thread: " + Thread.currentThread().getName()));
		thread3.start();
		thread3.join();
		thread1.join();
		System.out.println("Testando Join e sleep!");
		
	}

	}
