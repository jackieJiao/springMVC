package com.sinoway.zero.mapper;

import org.apache.ibatis.annotations.*;

import com.sinoway.zero.bean.User;



import java.lang.Long;
import java.lang.String;
import java.util.List;


  
public interface UserMapper {


    public List<User> FindUser(User user);

    @Select("SELECT * FROM users_web WHERE id = #{id}")
    public User findUser(Long id);

    @Select("SELECT * FROM users_web WHERE username = #{username}")
    public User findUserByUsername(String username);

   /* @Select("SELECT users.*,authorities.* FROM users,authorities where users.username=authorities.username")
	public List<Permission> findUsers();

    @Select("SELECT users.*,authorities.* FROM users,authorities where users.username=authorities.username AND users.id = #{id}")
    public Permission findUserById(Long id);


	@Insert("INSERT INTO users(username,password,realname,phone,company,registrationTime,enabled) values(#{username},#{password},#{realname},#{phone},#{company},#{registrationTime},#{enabled})")
	public void saveUser(User user);

    @Insert("INSERT INTO authorities(username,authority) values(#{username}, #{authority})")
    public void saveAuthority(Authority authority);*/

    @Delete("DELETE FROM users WHERE id = #{id}")
    public void deleteUser(Long id);

 /*   @Delete("DELETE FROM authorities WHERE username = #{username}")
    public void deleteAuthority(@Param(value="username")String username);*/


    @Update("UPDATE users SET username = #{username},password = #{password},realname = #{realname},company = #{company},phone = #{phone},enabled = #{enabled} WHERE id = #{id}")
    public void updateUser(@Param(value="id")Long id,@Param(value="username")String username,@Param(value="password")String password,
                           @Param(value="realname")String realname,@Param(value="company")String company,@Param(value="phone")String phone,
                           @Param(value="enabled")boolean enabled
                           );

    @Update("UPDATE users SET lastLoginTime = #{lastLoginTime} WHERE username = #{username}")
    public void updateUserLastLoginTime(@Param(value="lastLoginTime")String lastLoginTime,@Param(value="username")String username);


  /*  @Update("UPDATE authorities SET username = #{username},authority = #{authority} WHERE username = #{oldusername}")
    public void updateAuthority(@Param(value="username")String username,@Param(value="oldusername")String oldusername,@Param(value="authority")String authority);
*/

   /* @Select("SELECT * FROM permissions")
    public List<Permissions> findPermissions();

    @Select("SELECT * FROM permissions WHERE id = #{id}")
    public Permissions findById(Long id);

    @Insert("INSERT INTO permissions(name, path, role) values(#{name}, #{path}, #{role})")
    public void savePermission(Permissions permissions);

    @Delete("DELETE FROM permissions WHERE id = #{id}")
    public void deletePermission(Long id);

    @Update("UPDATE permissions SET name = #{name},path = #{path},role = #{role} WHERE id = #{id}")
    public void updatePermission(@Param(value = "name") String name, @Param(value = "path") String path, @Param(value = "role") String role, @Param(value = "id") Long id);
*/


}
        