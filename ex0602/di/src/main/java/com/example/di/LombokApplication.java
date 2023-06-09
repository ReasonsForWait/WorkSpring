package com.example.di;

import com.example.di.bean.DataBean1;
import com.example.di.bean.DataBean2;
import com.example.di.bean.DataBean3;
import com.example.di.bean.DataBean4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LombokApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(LombokApplication.class, args);

        DataBean1 data1 = cac.getBean(DataBean1.class);
        data1.setData1("aaa");
        System.out.println(data1.getData1());

        DataBean2 data2 = cac.getBean(DataBean2.class);
        System.out.println(data2.getData1());

        DataBean3 data3 = cac.getBean(DataBean3.class);
        System.out.println(data3.toString());

        DataBean4 data4 = cac.getBean(DataBean4.class);
        System.out.println(data4);
    }
}
