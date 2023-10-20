package software.vn.musicprj.controller;

        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.validation.BindingResult;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;
        import org.springframework.web.servlet.mvc.support.RedirectAttributes;
        import software.vn.musicprj.dto.ListDto;
        import software.vn.musicprj.entities.ListMusicEntity;
        import software.vn.musicprj.service.ListService;
        import software.vn.musicprj.utils.FileUtils;

        import javax.validation.Path;
        import javax.validation.Valid;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.util.List;

@Controller
@RequestMapping("/music/backend/track")
public class ListController {
    @Autowired
    ListService listService;

    @GetMapping("list")
    public String list(Model model, @RequestParam(name = "name", required = false) String name) {
        Object obj = null;
        if (name == null) {
            obj = listService.findAll();
        } else {
            obj=listService.searchByInstrumentName( name);
        }
        model.addAttribute("title", name);
        model.addAttribute("tracks", obj);
        if (obj instanceof ListMusicEntity) {
            ListMusicEntity music = (ListMusicEntity) obj;
            String deletePath = null;
            if (music.getMusicType().equals("solo")) {
                deletePath = "/music/backend/track/solo?name=" + name;
            } else if (music.getMusicType().equals("duet")) {
                deletePath = "/music/backend/track/duet?name=" + name;
            }
            model.addAttribute("deletePath", deletePath);
        } else {
            model.addAttribute("deletePath", "/music/backend/track/delete");
        }

        return "/jsp/music_list.jsp";
    }
    @GetMapping("upload")
    public String create(Model model) {
        model.addAttribute("title", "Tạo bài nhạc mới");
        model.addAttribute("listDto", new ListDto());
        return "/jsp/create_list.jsp";
    }


    @PostMapping(value = "save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@Valid ListDto listDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       @RequestParam(name = "musicType") String trackType) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/jsp/create_list.jsp";
        }
        listService.save(listDto);
        redirectAttributes.addFlashAttribute("message", "Tạo bài nhạc thành công!");

        if (trackType.equals("solo")) {
            return "redirect:/music/backend/track/solo";
        } else if (trackType.equals("duet")) {
            return "redirect:/music/backend/track/duet";
        } else {
            return "redirect:/music/backend/track/list";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable Integer id) throws IOException {
        listService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/music/backend/track/list";
    }


}
