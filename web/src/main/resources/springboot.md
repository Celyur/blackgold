#####1.使用@PropertySource注解
    如果需要使用@PropertySource注解的方式加载值，就要使用properties为后缀的配置文件，这是由于yml文件
    不能通过@PropertySource注解加载;
#####2.注解@EnableDiscoveryClient,@EnableEurekaClient的区别
    /**
    * @EnableEurekaClient and @EnableDiscoveryClient has some deference:@EnableDiscoveryClient lives in spirng-cloud-commons,but
    * the @EnableEurekaClient lives in spring-cloud-netflix,if you want to have a consolidate project ,and you know spring cloud has so many
    * discory server likes eureka,consle and zookeeper,in fact @EnableEurkaClient just containt @EnableDiscoryClient ,althought has some other suport in the
    * futrue ,but now recommend to use @EnableDiscoryClient
    */