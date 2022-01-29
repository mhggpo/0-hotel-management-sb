package com.zero.hotelmanagement.controller;

import com.zero.hotelmanagement.pojo.User;
import com.zero.hotelmanagement.service.UserService;
import com.zero.hotelmanagement.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Controller
@RestController
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    @ResponseBody
    public HashMap<String,Object> login(String uname,String pwd)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<User> userList= userService.selectUserByName(uname);
        boolean isRight=false;
        int id=0;
        String power="";
        for (User u:userList) {
            if(SHA.equals(pwd,u.getPwd()))
            {
                isRight=true;
                id=u.getId();
                power=u.getPower();
                break;
            }
        }
        map.put("contains",isRight);
        map.put("id",id);
        map.put("power",power);
        return map;
    }

    @RequestMapping("getUser")
    @ResponseBody
    public HashMap<String,Object> getUser(String page)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<User> userList= userService.getUser(Integer.parseInt(page));
        int count=userService.countAllUsers();
        map.put("count",count);
        map.put("List",userList);
        return map;
    }

    @RequestMapping("delUser")
    @ResponseBody
    public HashMap<String,Object> delUser(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryDelUser:ID:"+id);
        boolean isSuccess= userService.deleteUser(Integer.parseInt(id))>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public HashMap<String,Object> addUser(User user)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryAddUser:"+user);
        boolean isSuccess=userService.insertUser(user)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("editUser")
    @ResponseBody
    public HashMap<String,Object> editUser(User user)
    {
        HashMap<String,Object> map=new HashMap<>();
        System.out.println("TryUpdateUser:"+user);
        boolean isSuccess=userService.updateUser(user)>0;
        map.put("handle",isSuccess);
        return map;
    }

    @RequestMapping("searchUserById")
    @ResponseBody
    public HashMap<String,Object> searchUserById(String id)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<User> userList= userService.selectUserById(Integer.parseInt(id));
        map.put("List",userList);
        return map;
    }

    @RequestMapping("searchUserByUname")
    @ResponseBody
    public HashMap<String,Object> searchUserByUname(String uname)
    {
        HashMap<String,Object> map=new HashMap<>();
        List<User> userList= userService.selectUserByName(uname);
        map.put("List",userList);
        return map;
    }
}
