package cn.edu.nwsuaf.controller;

import cn.edu.nwsuaf.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by puhui on 2017/3/10.
 */
//@RestController
//@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getName(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的name来获取用户详细信息")
    @ApiImplicitParam(name = "name", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long name) {
        return users.get(name);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的name来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
        @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{name}", method=RequestMethod.PUT)
    public String putUser(@PathVariable String name, @RequestBody User user) {
        User u = users.get(name);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(name, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的name来指定删除对象")
    @ApiImplicitParam(name = "name", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value="/{name}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable String name) {
        users.remove(name);
        return "success";
    }

}