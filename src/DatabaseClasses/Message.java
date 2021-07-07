package DatabaseClasses;

public class Message {
	private String message;
	private String remitter;
	private String addressee;
	
	public Message(String message, String remitter, String addressee) {
		this.message = message;
		this.remitter = remitter;
		this.addressee = addressee;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRemitter() {
		return remitter;
	}

	public void setRemitter(String remitter) {
		this.remitter = remitter;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	
}