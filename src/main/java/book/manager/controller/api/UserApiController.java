package book.manager.controller.api;

import book.manager.entity.AuthUser;
import book.manager.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/user")
public class UserApiController {

    @Resource
    BookService service;

    @RequestMapping(value = "/borrow-book",method = RequestMethod.GET)
    public String borrowBook(@RequestParam("id") int bid,
                             @SessionAttribute("user")AuthUser user){
        service.borrowBook(bid,user.getId());
        return "redirect:/page/user/book";
    }

    @RequestMapping(value = "/return-book",method = RequestMethod.GET)
    public String returnBook(@RequestParam("id") int bid,
                             @SessionAttribute("user")AuthUser user){

        service.returnBook(bid,user.getId());
        return "redirect:/page/user/book";
    }
}
