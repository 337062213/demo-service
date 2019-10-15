package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.example.user.vo.UserGroupVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Springboot 设置跨域的三种方式
 * 1.在需要跨域的整个Controller或者单个方法上添加@CrossOrigin注解
 * 2.@Configuration
 *   public class WebMvcConfig extends WebMvcConfigurerAdapter {
 *      @Override
 *      public void addCorsMappings(CorsRegistry registry) {
 *      registry.addMapping("/**")
 *        .allowedOrigins("*")
 *        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
 *        .maxAge(3600)
 *        .allowCredentials(true);
 *      }
 *   }
 * 3.@Component
 *   //这里的“/*” 表示的是需要拦截的请求路径
 *   @WebFilter(urlPatterns = "/*", filterName = "authFilter") 
 *   public class PassHttpFilter implements Filter {
 *      @Override
 *      public void init(FilterConfig filterConfig) throws ServletException { }
 *        @Override
 *        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
 *            HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
 *            httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
 *            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
 *            httpResponse.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080");
 *            filterChain.doFilter(servletRequest, httpResponse);
 *        }
 *        @Override
 *        public void destroy() { }
 *   }
 * @author EDZ
 * @date 2019/10/15
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:8000","http://localhost:8001","http://localhost:8002","http://localhost:8003","http://localhost:8004"},maxAge = 3600)
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/{uid}")
    public User findUserById(@PathVariable("uid") String uid) {
        User user = userService.findUserById(uid);
        logger.info("findUserById =>" + user.toString());
        return user;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.insertUser(user);

    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/delete/{uid}")
    public void deleteUser(@PathVariable("uid") String uid) {
        userService.deleteUser(uid);

    }

    @GetMapping("/findByParams")
    public List<User> findAllUser(@RequestParam(defaultValue = "") String name,
                                  @RequestParam(defaultValue = "") String gid) {

        List<User> users = userService.findAllUser(name,gid);
        return users;

    }

    @GetMapping("/find/{uid}")
    public UserGroupVo findUserGroupVo(@PathVariable("uid") String uid) {
        UserGroupVo userGroupVo = userService.findUserGroupVo(uid);
        logger.info("findUserGroupVo =>" + userGroupVo.toString());
        return userGroupVo;
    }

    @GetMapping("/find")
    public List<User> findUserByCondition(User user) {
        return userService.findUserByCondition(user);
    }


}
