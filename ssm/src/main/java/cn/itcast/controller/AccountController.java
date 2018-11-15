package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帐户web
 */
//@Controller("account")
@RequestMapping("account")
@Controller
public class AccountController {
    @Autowired//注入依赖
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll( Model model) {
        System.out.println("表现层：查询所有账户...");
        // 调用service的方法
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        model.addAttribute("acccounts",list);
        return "list";
    }

    /**
     * 保存
     *
     * @return
     */
    @RequestMapping("/save")
    public String save(Account account) throws IOException {
        accountService.saveAccount(account);
        System.out.println("表现层：保存账户...");
        return  "redirect:findAll";
    }


}
