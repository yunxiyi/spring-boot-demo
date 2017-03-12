package cn.edu.nwsuaf.rest;

import cn.edu.nwsuaf.model.User;
import cn.edu.nwsuaf.service.UserService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangrongchao on 2017/3/9.
 */
@RestController
@RequestMapping(value="/api/v1")
@EnableSwagger2
public class SwaggerController {

    @Autowired
    UserService userService;

    @ApiOperation(value="Get all users",notes="requires noting")
    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return userService.findUserInfo();
    }

    @ApiOperation(value="Get user with id",notes="requires the id of user")
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable long id){

        return userService.selectByPrimaryId(id);
    }
}
