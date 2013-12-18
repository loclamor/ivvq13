package ivvq13

class Message {

    static constraints = {
    }
//git add lien/vers/truc
//git commit -m "My message"
//git push origin master
	
	private long id
	private String content
	private String title
	private User author



	public Message(long id, String content, String title, User author) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.author = author;
	}	


	public Message() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
		this.author = author;
	}
	 
	
}
