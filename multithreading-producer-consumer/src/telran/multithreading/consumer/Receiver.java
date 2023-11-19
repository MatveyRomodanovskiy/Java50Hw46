package telran.multithreading.consumer;

import telran.multithreading.messaging.MessageBox;

public class Receiver extends Thread {
	private static final String END_OF_MESSAGES = "eom";
	private static boolean flag = true;
	private MessageBox messageBox;

	public Receiver(MessageBox messageBox) {
		this.messageBox = messageBox;
		//FIXME HW #46 fix setting daemon
//		setDaemon(true); //HW #46 remove it
	}
	@Override
	public void run() {
		while(flag) {
			String message = null;
			try {
				message = messageBox.take();
				if (message.equalsIgnoreCase(END_OF_MESSAGES)) {
					flag = false;
					sleep(5);
					throw new InterruptedException("End of messages stream");
				}
			} catch (InterruptedException e) {
				System.out.printf("thread id: %d, message: %s\n", getId(),e.getMessage());
				break;
			}
			System.out.printf("thread id: %d, message: %s\n", getId(),message );
		}
	}
}
