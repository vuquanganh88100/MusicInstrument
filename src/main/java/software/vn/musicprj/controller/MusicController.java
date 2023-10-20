package software.vn.musicprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import software.vn.musicprj.dto.UserDto;
import software.vn.musicprj.entities.ListMusicEntity;
import software.vn.musicprj.service.ListService;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private ListService listService;

    @GetMapping("home")
    public String home() {
        return "/jsp/home.jsp";
    }
    @GetMapping("create")
    public String create(Model model,
                         @RequestParam(name = "name",
                                 required = false) String name){
        //model: chuyền biến từ java -> jsp
//        Object authors= userService.findAllAuthor();
        model.addAttribute("title", "Tạo Mới User");
        UserDto userDto= new UserDto();
        model.addAttribute("userDto",userDto);
//        model.addAttribute("authors", authors);
        return "/jsp/signup.jsp";
    }

    @GetMapping("login")
    public String login() {
        return "/jsp/login.jsp";
    }



    @GetMapping("backend/track/solo")
    public String solo(Model model) {
        List<ListMusicEntity> soloTracks = listService.findSoloTracks();
        model.addAttribute("tracks", soloTracks);
        model.addAttribute("deletePath", null);
        return "/jsp/music_list.jsp";
    }

    @GetMapping("backend/track/duet")
    public String duet(Model model){
        List<ListMusicEntity> duetTracks = listService.findDuetTracks();
        model.addAttribute("tracks", duetTracks);
        model.addAttribute("deletePath", null);

        return "/jsp/music_list.jsp";
    }
}
