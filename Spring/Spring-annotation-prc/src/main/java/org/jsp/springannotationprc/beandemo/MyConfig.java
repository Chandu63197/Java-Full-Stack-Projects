package org.jsp.springannotationprc.beandemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans(value= {@ComponentScan("org.jsp.springannotationprc")})
public class MyConfig {
   @Bean
   public List<String> getList(){
	   return new ArrayList<String>(Arrays.asList("Virat","Rahul","Dhoni"));
   }
   @Bean
   public Set<Integer> getSet(){
	   return new HashSet<Integer>(new ArrayList(Arrays.asList(101,102,103)));
   }
}
