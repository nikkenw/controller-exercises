package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handles request of the form hello/name?=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @RequestMapping(value="hello", method={RequestMethod.POST})
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }
        return createMessage(name, language);
    }

    public String createMessage(String n, String l){
        String greeting = "";
        if(l.equals("English")){
            greeting = "Hello";
        } else if (l.equals("French")){
            greeting = "Bonjour";
        } else if (l.equals("German")){
            greeting = "Hello but in German";
        } else if (l.equals("Spanish")){
            greeting = "Hola";
        } else if (l.equals("Rusian")){
            greeting = "Russian Greeting";
        }
        return greeting + " " + n;
    }


    @GetMapping("form")
    @ResponseBody
    public String helloform(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='helloPost'>" +   //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "<option>Choose a language</option>" +
                "<option>English</option>" +
                "<option>French</option>" +
                "<option>German</option>" +
                "<option>Spanish</option>" +
                "<option>Russian</option>" +
                "<input type='submit' value='Greet Me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
