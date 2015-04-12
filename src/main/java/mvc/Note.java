package mvc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Note {

    private Long id;
    private String content;
    private String author;

    public Note() {}

    public Note(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Note(Long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public static Note create(String content, String author) {
        JdbcTemplate jdbcTemplate = SpringMvcApplication.getJdbcTemplate();
        int noteId = jdbcTemplate.update("INSERT INTO notes(content, author) values (?,?)", content, author);
        Note note = new Note(content, author);
        return note;
    }

    public static Note find(Long id) {
        JdbcTemplate jdbcTemplate = SpringMvcApplication.getJdbcTemplate();
        List<Note> notes = jdbcTemplate.query("SELECT id, content, author FROM notes WHERE id = ?", new Object[]{id},
                new RowMapper<Note>() {
                    @Override
                    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Note(rs.getLong("id"), rs.getString("content"),
                                rs.getString("author"));
                    }
                });
        return notes.get(0);
    }

    public static List<Note> all() {
        JdbcTemplate jdbcTemplate = SpringMvcApplication.getJdbcTemplate();
        List<Note> notes = jdbcTemplate.query("SELECT * FROM notes;", new Object[]{},
                new RowMapper<Note>() {
                    @Override
                    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Note(rs.getLong("id"), rs.getString("content"),
                                rs.getString("author"));
                    }
                });
        return notes;
    }
}
