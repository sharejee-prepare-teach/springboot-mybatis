package com.techprimers.mybatis.springbootmybatis.resource;

import com.techprimers.mybatis.springbootmybatis.mapper.UsersMapper;
import com.techprimers.mybatis.springbootmybatis.model.Users;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }


    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @GetMapping("/update")
    private List<Users> update() {

        Users users = new Users();
        users.setName("Youtube");
        users.setSalary(2333L);

        usersMapper.insert(users);

        return usersMapper.findAll();
    }

    @GetMapping("/delete/{id}")
    private void deleteUser(@PathVariable("id") Integer id){
        System.out.println("ID: "+id);
        usersMapper.delete(id);
    }

    @RequestMapping(value = "/rupdate/{id}",method = RequestMethod.PUT)
    private void updateUser(@Valid Users user,@PathVariable("id") Integer id){
        System.out.println(user);
        System.out.println(id);
    }
    @RequestMapping(value = "/updateUsers/{id}",method = RequestMethod.PUT)
    private List<Users> updateUsers(@RequestBody @Valid Users user,@PathVariable("id") Integer id) {
        Users users = new Users();
        users.setName(user.getName());
        users.setSalary(user.getSalary());
        users.setId(id);
        usersMapper.update(users);
        return usersMapper.findAll();
    }

}
