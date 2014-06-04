package com.nerv828.web.group;

import com.nerv828.entity.Group;
import com.nerv828.entity.User;
import com.nerv828.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @RequestMapping(value = "create")
    public String create(@Valid Group group){

        groupService.createGroup(group);

        return "";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String init(){
        return "group/create";
    }
    @RequestMapping(value = "checkName")
    public String checkName(@RequestParam("name") String name)  {
        if(groupService.findGroupByName(name)==null){
            return "true";
        } else {
            return "false";
        }

    }




}
