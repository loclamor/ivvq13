package ivvq13

import groovy.lang.Category;

import java.util.ArrayList;

class Document {

  
	static constraints = {
    }

//class attributes
	private long id
	private String title
	private String content
	private Category category
	private User user
	private ArrayList<Message> messages
	private ArrayList<Tag> tags
	private ArrayList<Rating> ratings
	private ArrayList<Attachment> attachments



 
	public Document(long id, String title, String content, Category category,
			User user, ArrayList<Message> messages, ArrayList<Tag> tags,
			ArrayList<Rating> ratings, ArrayList<Attachment> attachments) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.user = user;
		this.messages = messages;
		this.tags = tags;
		this.ratings = ratings;
		this.attachments = attachments;
	}	
	
	public Document() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	public ArrayList<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList<Attachment> attachments) {
		this.attachments = attachments;
	}
		
		
	
}
