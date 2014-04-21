package gsa.muk.app;

public class RssItem {

	private final String title;
    private final String link;
    private final String description;
    private final String author;
    private final String guid;
	  
 
    public String getDescription() {
		return description;
	}

	public String getAuthor() {
		return author;
	}

	public String getGuid() {
		return guid;
	}

	public RssItem(String title, String link, String description, String author, String guid) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.author = author;
        this.guid = guid;
    }
 
    public String getTitle() {
        return title;
    }
 
    public String getLink() {
        return link;
    }
}
