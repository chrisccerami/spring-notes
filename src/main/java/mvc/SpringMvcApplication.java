package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(SpringMvcApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;


    public void run(String... string) throws Exception {
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table notes if exists");
        jdbcTemplate.execute(("create table notes(" +
                "id serial, content varchar(255), author varchar(255))"));
    }

    public static JdbcTemplate getJdbcTemplate() {
        return context.getBean(JdbcTemplate.class);
    }

}