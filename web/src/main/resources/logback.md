##此文件进行对logback-spring.xml的配置进行详解
####1.\<configuration>
    <configuration scan="true" scanPeriod="10 seconds"></configuration> 这个是根节点，根节点
    <configuration>有5个子节点，分别为<root>、<contextName>、<property>、<appender>、<logger>.
    scan: 当此属性设置为true时，配置文件如果发生改变，将会被重新加载，默认值为true;
    scanPeriod: 设置监测配置文件是否有修改的时间间隔，如果没有给出时间单位，默认单位是毫秒。
    当scan为true时，此属性生效。默认的时间间隔为1分钟;
    debug: 当此属性设置为true时，将打印出logback内部日志信息，实时查看logback运行状态。默认值为false;

####2.\<root> 节点
    root节点是必选节点，用来指定最基础的日志输出级别，只有一个level属性;
    level: 用来设置打印级别，大小写无关：TRACE, DEBUG, INFO, WARN, ERROR, ALL 和 OFF，不能设置为INHERITED或者同义词NULL。
    默认是DEBUG。可以包含零个或多个元素，标识这个appender将会添加到这个loger;
    示例：
        <root level="debug">
                <appender-ref ref="info_file" />
                <appender-ref ref="error_file" />
        </root>

####3.\<contextName>设置上下文名称
    每个logger都关联到logger上下文，默认上下文名称为“default”。但可以使用设置成其他名字，用于区分不同应用程序的记录。
    一旦设置，不能修改,可以通过%contextName来打印日志上下文名称，一般来说我们不用这个属性，可有可无；
    示例：
        <contextName>logback-test</contextName>

####4.\<property>设置变量
    用来定义变量值的标签， 有两个属性，name和value；其中name的值是变量的名称，value的值时变量定义的值。
    通过定义的值会被插入到logger上下文中。定义变量后，可以使“${}”来使用变量；参数可以通过application.yml传过来；
    示例:
        <property name="logback.dir" value="/users/logs/"/>
         <property name="logback.appname" value="web"/>

####5.\<appender>格式化日志输出
    appender用来格式化日志输出节点，有两个属性name和class，class用来指定哪种输出策略，常用就是控制台输出策略和文件输出策略。
    示例：
            <!--输出到文件 RollingFileAppender-->
            <appender name="info_file" class="ch.qos.logback.core.rolling.RollingFileAppender">
                <!--如果只是想要 Info 级别的日志，只是过滤 info 还是会输出 Error 日志，因为 Error 的级别高，
                  所以我们使用下面的策略，可以避免输出 Error 的日志-->
                <filter class="ch.qos.logback.classic.filter.LevelFilter">
                    <!--过滤 Error-->
                    <level>ERROR</level>
                    <!--匹配到就禁止-->
                    <onMatch>DENY</onMatch>
                    <!--没有匹配到就允许-->
                    <onMismatch>ACCEPT</onMismatch>
                </filter>
                <!--日志名称，如果没有File 属性，那么只会使用FileNamePattern的文件路径规则
                如果同时有<File>和<FileNamePattern>，那么当天日志是<File>，明天会自动把今天
                的日志改名为今天的日期。即，<File> 的日志都是当天的。-->
                <File>${LOG_PATH}/info.log</File>
                <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->
                <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                    <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->
                    <fileNamePattern>${LOG_PATH}/info-%d{yyyyMMdd}.log.%i</fileNamePattern>
                    <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                        <maxFileSize>500MB</maxFileSize>
                    </timeBasedFileNamingAndTriggeringPolicy>
                    <!--只保留最近2天的日志-->
                    <maxHistory>2</maxHistory>
                    <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->
                    <!--<totalSizeCap>1GB</totalSizeCap>-->
                </rollingPolicy>
                <layout class="ch.qos.logback.classic.PatternLayout">
                    <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} -%msg%n</Pattern>
                </layout>
                <!--日志输出编码格式化-->
                <!--<encoder class="ch.qos.logback.classic.PatternLayout">
                    <charset>UTF-8</charset>
                    <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %logback-test [%thread] %-5level %logger{36} -%msg%n</Pattern>
                </encoder>-->
            </appender>

####6.\<logger>
    用来设置某一个包或者具体的某一个类的日志打印级别，以及指定<appender>;
    <logger>仅有一个name属性，一个可选的level和一个可选的addtivity属性。
    name:用来指定受此loger约束的某一个包或者具体的某一个类。
    level:用来设置打印级别，大小写无关：TRACE, DEBUG, INFO, WARN, ERROR, ALL 和 OFF，还有一个特俗值INHERITED或者同义词NULL，代表强制执行上级的级别。
    如果未设置此属性，那么当前loger将会继承上级的级别。
    addtivity:是否向上级loger传递打印信息。默认是true。

####7.多环境日志输出
      <!-- 测试环境+开发环境. 多个使用逗号隔开. -->
      <springProfile name="test,dev">
          <logger name="com.black.gold.web.WebApplication" level="DEBUG" additivity="false">
              <appender-ref ref="consoleLog"/>
          </logger>
      </springProfile>

      <!-- 生产环境. -->
      <springProfile name="prod">
          <logger name="com.black.gold.web.WebApplication" level="INFO" additivity="false">
              <appender-ref ref="consoleLog"/>
          </logger>
      </springProfile>