package software.vn.musicprj.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import software.vn.musicprj.dto.UserDto;
import software.vn.musicprj.entities.MusicuserEntity;
import software.vn.musicprj.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/music/backend/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("list")// Phương thức Get: Lấy dữ liệu ==> load trang ra dự form có sẵn trước
//    @ResponseBody// trả về dạng json
    public String list(Model model,
                       @RequestParam(name = "name",
                               required = false) String name){
        //model: chuyền biến từ java -> jsp
        Object obj= null;
        if(name==null){
            obj=userService.findAll();
        }else{
            obj=userService.searchByEmail(name);
        }
        model.addAttribute("title", name);
        model.addAttribute("list", obj);
        return "/jsp/list.jsp";
    }

//    @GetMapping("edit/{id}")// Phương thức Get: Lấy dữ liệu
//        public String create(Model model, @PathVariable Integer id){
////        Object authors = bookService.findAllAuthor();
//            model.addAttribute("user", userService.getById(id));
//            model.addAttribute("title", "Cập nhật tài khoản");
////        model.addAttribute("authors", authors);
//            return "/jsp/user_edit.jsp";
//    }
    @GetMapping("delete/{id}")
    public String delete(RedirectAttributes redirectAttributes, @PathVariable Integer id){
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/music/backend/user/list";
    }
    @PostMapping(value = "save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save( UserDto userDto,
                         Model model, RedirectAttributes redirectAttributes) {
        userService.save(userDto,passwordEncoder);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công");
        return "redirect:/music/home";
    }
}

