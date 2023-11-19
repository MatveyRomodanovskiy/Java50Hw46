package telran.multithreading.producer;

import telran.multithreading.messaging.MessageBox;

public class Sender extends Thread {
  private static final String END_OF_MESSAGES = "eom";
private MessageBox messageBox;
  private int nMessages;
public Sender(MessageBox messageBox, int nMessages) {
	this.messageBox = messageBox;
	this.nMessages = nMessages;
}
  @Override
  public void run() {
	  for (int i = 1; i <= nMessages; i++) {
		  messageBox.put("message" + i);
  }
	  messageBox.put(END_OF_MESSAGES); 
  }
}
