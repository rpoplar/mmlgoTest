package com.mmlgo.yh.controllers;

import com.mmlgo.yh.models.Person;
import com.mmlgo.yh.models.ProjectMaster;
import com.mmlgo.yh.models.TempRate;
import com.mmlgo.yh.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@EnableAutoConfiguration
@RequestMapping("/Home")
public class HomeController {
    @Autowired
    private ProjectService service;

    @Value("${book.name}")
    private String BookName;

    @Value("${book.author}")
    private String Author;

    @Value("${book.price}")
    private String Price;

    @ResponseBody
//    @GetMapping("/echo")
    @RequestMapping(value = "/echo", produces = "text/plain;charset=UTF-8")
    public String echo(String msg, String name, String age) {
        return "Server Received Your Message：" + msg + " \\r\\n Nmae;" + name + " \\r\\n Age;"
                + age + "</br> bookName = " + this.BookName + "   Author = " + this.Author + "    Price=" + this.Price;
    }

    @ResponseBody
    @RequestMapping(value = "echo1", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String echo1() {
        return "Server Received Your Message： fuck";
    }

    @RequestMapping("/Project")
    public String Project(Model model, int sysNo) throws ParseException {
        ProjectMaster proj = service.GetProjectMasterBySysNo(sysNo);
        model.addAttribute("p", proj);
        List<ProjectMaster> list = new ArrayList<ProjectMaster>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2018-02-09 10:30:";
        //foreach
        for (int i = 0; i < 10; i++) {
            ProjectMaster p = new ProjectMaster();
            p.setProjectName("Project" + i);
            p.setProjectCode("Code-001-00x" + i);
            p.setInDate(sdf.parse(dateStr + (i + 1)));
            p.setStatus(i);
            list.add(p);
        }
        model.addAttribute("list", list);
        return "Project";
    }

    @RequestMapping("/m1")
    public ModelAndView getName() throws Exception {
        Person person = new Person();
        person.setName("james");
        person.setAge(28);
        person.setAddress("成都市武侯区1");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1985-04-22");
        person.setBirthday(date);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("p", person);
        return new ModelAndView("index", map);
    }

    @RequestMapping("/m2")
    public String getName(Map<String, Object> map) throws Exception {
        Person person = new Person();
        person.setName("james");
        person.setAge(28);
        person.setAddress("成都市武侯区2");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1985-04-22");
        person.setBirthday(date);
        map.put("p", person);
        return "index";
    }

    @RequestMapping("/m3")
    public String getName(Model model) throws Exception {
        Person person = new Person();
        person.setName("james");
        person.setAge(28);
        person.setAddress("成都市武侯区3");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1985-04-22");
        person.setBirthday(date);
        //把参数值放到request类里面去
        model.addAttribute("p", person);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/insertRate")
    public String InsertTempRate() throws Exception {
        TempRate rate = new TempRate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = format.parse("1985-04-22 10:32");
        rate.setType(1);
        rate.setQuantity(23);
        rate.setRate(new BigDecimal(1.23));
        rate.setEditDate(date);
        rate.setEditUserName("test");
        rate.setEditUserSysNo(1);
        rate.setInDate(date);
        rate.setInUserName("test");
        rate.setInUserSysNo(1);
        int count = this.service.InsertTemp_rate(rate);
        return "insert result :" + count;
    }

    @ResponseBody
    @RequestMapping("/BatchInsertRate")
    public String BatchInsertRate() throws Exception {

        List<TempRate> list = new ArrayList<>();
        for (int i = 6; i < 11; i++) {
            TempRate rate = new TempRate();
            //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            // format.parse("1985-04-22 10:32");
            Date date = new Date();
            rate.setType(i);
            rate.setQuantity(i * 10);
            rate.setRate(new BigDecimal( Math.random( )* i).setScale(2,BigDecimal.ROUND_HALF_UP));
            rate.setEditDate(date);
            rate.setEditUserName("test" + i);
            rate.setEditUserSysNo(i);
            rate.setInDate(date);
            rate.setInUserName("test" + i);
            rate.setInUserSysNo(i);
            Thread.sleep(1000);
            list.add(rate);
        }
        int count = this.service.BatchInsertTemp_rate(list);
        return "batch insert result :" + count;
    }
}
