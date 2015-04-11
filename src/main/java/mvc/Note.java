package mvc;

/**
 * Created by chriscerami on 4/11/15.
 */
public class Note {
    private String content;
    private String author;

    public Note(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return content + "by " + author;
    }
}
