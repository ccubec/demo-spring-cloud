package com.example.mybatis.rest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis.dao.UserMapper;
import com.example.mybatis.entity.User;
import com.example.mybatis.entity.result.ResultVo;
import com.example.mybatis.entity.vo.UserVo;
import com.example.mybatis.test.RealData;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zongk
 * @since 19-11-18 21:03
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("insert")
    public String insert(){
        User user = User.builder()
                .id(3)
                .wxId(null)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .roles(null)
                .build();


        userMapper.insert(user);
        return "success";
    }

    @GetMapping("selectOne")
    public ResultVo selectOne() throws Exception{
        long start = System.currentTimeMillis();
        Page<User> page = new Page<>(1, 100);
        IPage<User> res = userMapper.selectPage(page, new QueryWrapper<>());
        List<User> users = res.getRecords();
//        ExecutorService es = Executors.newFixedThreadPool(10);
//        Future<List<User>> f = es.submit(() -> userMapper.selectList(new QueryWrapper<>()));
//        List<User> users = f.get();
        long end = System.currentTimeMillis();
        System.out.println("时间是" + (end - start));
        UserVo user = new UserVo();
        user.setUserList(users);

        return ResultVo.isOk(user.getUserList().size());

    }

    @GetMapping("selectOne2")
    public ResultVo selectOne2() throws Exception{
        long start = System.currentTimeMillis();

//        List<User> users = userMapper.selectList(new QueryWrapper<>());
        ExecutorService es = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(2000);

//        Page<User> page = new Page<>(1,2000);
        Future<List<User>> f = es.submit(() -> {
            List<User> res1 = userMapper.selectList(new QueryWrapper<>());
            return res1;
        });
        long end1 = System.currentTimeMillis();
        System.out.println("第一步时间是" + (end1 - start));


        Page<User> page1 = new Page<>(1000,3000);
        Future<List<User>> f1 = es.submit(() -> {
            IPage<User> res2 = userMapper.selectPage(page1, new QueryWrapper<>());
            return res2.getRecords();
        });

        long end2 = System.currentTimeMillis();
        System.out.println("第二步时间是" + (end2 - start));
        
        
        Page<User> page2 = new Page<>(2000,5000);
        Future<List<User>> f2 = es.submit(() -> {
            IPage<User> res3 = userMapper.selectPage(page2, new QueryWrapper<>());
            return res3.getRecords();
        });
        long end = System.currentTimeMillis();
        System.out.println("第三步时间是" + (end - start));

        List<User> users = f1.get();
        long l = System.currentTimeMillis();

        System.out.println("第yiyi步时间是" + (l - start));
        System.out.println("第yiyi步时间是" + (l - end));

        List<User> users1 = f.get();
        System.out.println("第二一步时间是" + (System.currentTimeMillis() - l));
        System.out.println("第yiyi步时间是" + (l - end));
        List<User> users2 = f2.get();
        System.out.println("第二一步时间是" + (System.currentTimeMillis() - start));
        System.out.println("第二一步时间是" + (System.currentTimeMillis() - l));

        UserVo user = new UserVo();
        user.setUserList(users);
        user.setUserList1(users1);
        user.setUserList2(users2);

        long endend = System.currentTimeMillis();
        System.out.println("最后时间是" + (endend - start));
        return ResultVo.isOk();

    }

    @GetMapping("selectOne3")
    public ResultVo selectOne3() throws Exception{
        long start = System.currentTimeMillis();

//        Page<User> page = new Page<>(1,2000);
//        IPage<User> res = userMapper.selectPage(page, new QueryWrapper<>());
//        List<User> users = res.getRecords();
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        long end = System.currentTimeMillis();
        System.out.println("第一时间是" + (end - start));


        Page<User> page1 = new Page<>(1,2000);
        IPage<User> res1 = userMapper.selectPage(page1, new QueryWrapper<>());
        List<User> users1 = res1.getRecords();
        long end1 = System.currentTimeMillis();
        System.out.println("第二步时间是" + (end1 - start) + "  "+(end1 - end));



        Page<User> page2 = new Page<>(1000,3000);
        IPage<User> res2 = userMapper.selectPage(page2, new QueryWrapper<>());
        List<User> users2 = res2.getRecords();
        long end2 = System.currentTimeMillis();
        System.out.println("第三步时间是" + (end2 - start) + " " + (end2 - end1));


        UserVo user = new UserVo();
        user.setUserList(users);
        user.setUserList1(users1);
        user.setUserList2(users2);
        long end3 = System.currentTimeMillis();
        System.out.println("最后时间是" + (end3 - start) + " " + (end3 - end2));
        return ResultVo.isOk(user.getUserList().size());

    }

    @GetMapping("getFuture")
    public ResultVo getFuture() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        User user = new User();
        user.setRoles("admin");
        FutureTask<List<User>> future = new FutureTask<>(new RealData(user, userMapper));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start);
        List<User> users = future.get();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return ResultVo.isOk(users);
    }

    @GetMapping("getGuravaFuture")
    public ResultVo getGuravaFuture() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        User user = new User();
        user.setRoles("admin");

        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<List<User>> task = service.submit(new RealData(user, userMapper));

        UserVo userVo = new UserVo();
        task.addListener( () ->{
            try {
                System.out.println("异步处理成功");
                List<User> users = task.get();
                userVo.setUserList(users);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, MoreExecutors.directExecutor());

        System.out.println("主线程成功");
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return ResultVo.isOk(userVo);
    }

    @GetMapping("/getUserList")
    public ResultVo getUserList()  {
        long start = System.currentTimeMillis();
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return ResultVo.isOk(users);
    }
}
