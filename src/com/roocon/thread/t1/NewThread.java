package com.roocon.thread.t1;

public class NewThread implements Runnable {

	@Override
	public synchronized void run() {
		while(true) {
			try {
				System.out.println("子线程等待...."+Thread.currentThread().getName());
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("自定义的线程执行了...."+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		
		NewThread n = new NewThread();


		new Thread(() -> System.out.println("自定义的线程执行了...."+Thread.currentThread().getName())).start();
		
		// 初始化状态
		Thread thread = new Thread(n); // 创建线程,并指定线程任务
		
		thread.start(); // 启动线程
		
		while(true) {
			synchronized (n) {
				System.out.println("主线程执行了..."+Thread.currentThread().getName());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				n.notifyAll();
			}
			
		}
		
	}

}
