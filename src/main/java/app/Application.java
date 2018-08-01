package app;

import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.config.Charset;
import com.wix.mysql.config.MysqldConfig;
import com.wix.mysql.distribution.Version;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        runEmbeddedMySql();
        SpringApplication.run(Application.class, args);
    }

    private static void runEmbeddedMySql() {
        final MysqldConfig config = MysqldConfig
                .aMysqldConfig(Version.v5_5_latest)
                .withCharset(Charset.UTF8)
                .withPort(3306)
                .withUser("mysql", "root")
                .build();

        EmbeddedMysql.anEmbeddedMysql(config)
                .addSchema("entity")
                .start();
    }
}
