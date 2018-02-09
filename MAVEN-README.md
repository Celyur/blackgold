###maven的pom.xml 配置文件解释
####1. groupId,artifactId,package
    groupId和artifactId统称为“坐标”，是为了保证项目唯一性而提出的。
    groupId是项目组织唯一的标识符，实际对应JAVA的包的结构，
    ArtifactID是项目的唯一的标识符，实际对应项目的名称，就是项目根目录的名称。
    groupId一般分为多个段，一般第一段为域，第二段为公司名称。
    举个apache公司的tomcat项目例子：这个项目的groupId是org.apache，它的域是org，公司名称是apache，
    artifactId是tomcat。包结构package最好是以groupId.artifactId打头的。
####2. 父模块pom配置
    父pom是为了抽取统一的配置信息和依赖版本控制，方便子pom直接引用，简化子pom的配置。
    多模块项目中，父模块打包类型必须是pom，父模块中包含多个子模块，其中每个module(子模块)，都是一个maven项目。
    为什么多模块项目中，父模块打包类型必须是pom？
    任何一个Maven项目都需要定义POM元素packaging（如果不写则默认值为jar）。
    该元素决定了项目的打包方式。实际的情形中，如果你不声明该元素，Maven会帮你生成一个JAR包；
    如果你定义该元素的值为war，那你会得到一个WAR包；
    如果定义其值为POM（比如是一个父模块），那什么包都不会生成。
    除此之外，Maven默认还支持一些其他的流行打包格式，例如ejb3和ear。
    示例 <packaging>pom</packaging>  <!--父模块打包类型必须为pom-->
####3. 使用dependencyManagement管理依赖版本号和使用properties控制依赖包的版本号，便于版本维护
    一般在项目最顶层的父pom中使用该元素，让所有子模块引用一个依赖而不用显式的列出版本号。
    maven会沿着父子层次向上走，直到找到一个拥有dependencyManagement元素的项目，
    然后它就会使用在这个dependencyManagement元素中指定的版本号。
    dependencyManagement示例：  
            <dependencyManagement>
               <dependencies>
                   <dependency>
                       <groupId>org.springframework.boot</groupId>
                       <artifactId>spring-boot-dependencies</artifactId>
                       <!--使用properties中配置的版本号-->
                       <version>${spring-boot.version}</version>
                       <type>pom</type>
                       <scope>import</scope>
                   </dependency>
                   <dependency>
                       <groupId>org.springframework.cloud</groupId>
                       <artifactId>spring-cloud-dependencies</artifactId>
                       <version>${spring-cloud.version}</version>
                       <type>pom</type>
                       <scope>import</scope>
                   </dependency>
               </dependencies>
           </dependencyManagement>
    在properties标签中，添加各依赖包的版本号，然后在dependency中直接引用该依赖版本号的值即可。
    properties示例：
    <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
            <java.version>1.8</java.version>
            <!-- 在properties中统一控制依赖包的版本，更清晰-->
            <spring-cloud.version>Edgware.SR1</spring-cloud.version>
            <spring-boot.version>1.5.10.RELEASE</spring-boot.version>
            <junit.version>4.12</junit.version>
    </properties>
    这样配置后，spring-cloud,spring-boot的版本就受到了统一的管理；
####4.子模块pom配置
    子模块的parent要使用顶层的父模块
     示例：
     父模块pom：
        <groupId>com.black.gold</groupId>
        <artifactId>com.black.gold</artifactId>
        <packaging>pom</packaging>
        <version>1.0</version>
        <modules>
             <module>web</module>
        </modules>
     子模块pom： ---- 子模块的parent要使用顶层的父模块------
        <parent>
             <artifactId>com.black.gold</artifactId>
             <groupId>com.black.gold</groupId>
             <version>1.0</version>
         </parent>
         <modelVersion>4.0.0</modelVersion>
         <groupId>com.black.gold</groupId>
         <artifactId>web</artifactId>
         <version>0.0.1-SNAPSHOT</version>
         <packaging>jar</packaging>