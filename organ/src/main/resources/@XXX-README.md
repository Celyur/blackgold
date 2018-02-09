#Spring注解解释大汇合
#### @Entity
用于声明实体，对实体注释，任何Hibernate映射对象都要有这个注释；
### @Data
要用此注解，要在pom.xml文件引入lombok依赖。此注解可以省去显式声明setter,getter的方法，不用手动添加
setter,getter方法，会自动生成setter,getter方法，此注解用起来很方便。
### @Id
声明此属性为主键，该属性值可以通过自身创建；
### @GeneratedValue
指定主键的生成策略，有四个值：
TABLE  使用表保存id值；
IDENTITY  identityculumn
SEQUENCR   sequence
AUTO   根据数据库的不同使用上面三个
用法示例： @GeneratedValue(strategy= GenerationType.AUTO)
### @DynamicUpdate
动态更新
### @Service
用于标注业务层组件，
### @Controller
用于标注控制层组件（如struts中的action）,
### @Repository
用于标注数据访问组件，即DAO组件，
### @Component
泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。  