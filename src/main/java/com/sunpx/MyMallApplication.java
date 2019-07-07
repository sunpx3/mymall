package com.sunpx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@RestController
@SpringBootApplication
public class MyMallApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MyMallApplication.class, args);
    }

    @RequestMapping(value = "toHello",method = RequestMethod.GET)
    @ResponseBody
    public String toHello(){
        return "Hello Sir!";
    }


}
