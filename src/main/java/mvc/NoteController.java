package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {
    @RequestMapping("/notes")
    public String index(Model model) {
        model.addAttribute("notes", Note.all());
        return "index";
    }

    @RequestMapping("/notes/new")
    public String newNote(Model model) {
        model.addAttribute("note", new Note());
        return "new";
    }

    @RequestMapping(value="/notes", method= RequestMethod.POST)
    public String create(@RequestParam("content") String content, @RequestParam("author") String author, Model model) {
        Note note = Note.create(content, author);
        model.addAttribute("note", note);
        return "show";
    }

    @RequestMapping(value = "/notes/{noteId}", method=RequestMethod.GET)
    public String show(@PathVariable String noteId, Model model) {
        long id = Long.parseLong(noteId);
        Note note = Note.find(id);
        model.addAttribute("note", note);
        return "show";
    }
}
