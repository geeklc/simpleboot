### 公共配置工程

  1. 配置使用mybatis-plus做持久层框架。

  2. 配置基本的参数使用com.ch.dao.config.AppDaoProperties

  3. 在依赖本jar时请在maven中添加相关的依赖，并且在自己的项目中使用@MapperScan("com.ch.test.api.**.mapper")注解

  4. 数据模型使用：

         1. com.ch.common.base.AppBaseIdEntity：该实体定义了id，并且id的类型是Long，生成策略是com.ch.dao.support.DefaultIdGenerator中定义
         2. com.ch.common.base.AppBaseEntity：定义了表中创建人，创建时间，修改人，修改时间。对应的数据库字段类型bigint， timestamp， bigint， timestamp，并且创建时间会在插入数据的时候自动插入，不需要自动添加，修改时间在修改操作时自动添加。实现方式为com.ch.dao.support.DefaultMetaObjectHandler。
         3. com.ch.common.base.AppSoftDelEntity：比AppBaseEntity多了一个删除标识，delFlag，数据库字段类型int，0：未删除，1：已删除。该字段值不需要手动维护，同样是系统自动处理。

     上述几个实体可以根据自己的需要使用。

  5. id生成方式，在配置com.ch.dao.support.DefaultIdGenerator中定义默认的配置。如果个人需要自定义实现方式，可以实现com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator来定义，并且使用注解@Component

  6. 支持resultMap为java.util.Map时key驼峰格式命名。

     