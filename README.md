# Additional MyBatis type handlers for Java 8 runtime without extra dependencies

## Array support
Experimental feature. Tested only with postgresql.

## Java 8 time (JSR 310) support for Mybatis
Provides mybatis handlers for core java.time.\* types:
- java.time.Instant (via java.sql.Timestamp)
- java.time.LocalDate (via java.sql.Date)
- java.time.LocalDateTime (via java.sql.Timestamp)
- java.time.LocalTime (via java.sql.Time)
- java.time.OffsetDateTime (via java.sql.Timestamp)
- java.time.ZonedDateTime (via java.sql.Timestamp)

## Java properties like fields support
Experimental feature (almost working but not fully tested). 
Allows you to store your string key-value maps into text fields.


[![Release](https://jitpack.io/v/javaplugs/mybatis-types.svg)](https://jitpack.io/#javaplugs/mybatis-types)  
[API javadoc](https://jitpack.io/com/github/javaplugs/mybatis-types/-SNAPSHOT/javadoc/)

## Add to your project

You can add this artifact to your project using [JitPack](https://jitpack.io/#javaplugs/mybatis-types).  
All versions list, instructions for gradle, maven, ivy etc. can be found by link above.

To get latest commit use -SNAPSHOT instead version number.

## Configure

### Mybatis config
```
<!-- mybatis-config.xml -->
<typeHandlers>
  <package name="com.github.javaplugs.mybatis"/>
</typeHandlers>
```

Or you can specify each type handler class one by one.
In a case if you are need particular handlers only.

```
<!-- mybatis-config.xml -->
<typeHandlers>
  <typeHandler handler="com.github.javaplugs.mybatis.InstantTypeHandler"/>
  <typeHandler handler="com.github.javaplugs.mybatis.LocalDateTypeHandler"/>
  <typeHandler handler="com.github.javaplugs.mybatis.LocalDateTimeTypeHandler"/>
  <typeHandler handler="com.github.javaplugs.mybatis.LocalTimeTypeHandler"/>
  <typeHandler handler="com.github.javaplugs.mybatis.OffsetDateTimeTypeHandler"/>
  <typeHandler handler="com.github.javaplugs.mybatis.ZonedDateTimeTypeHandler"/>
</typeHandlers>
```

### Mybatis via Spring
```
<bean id="SomeId" class="org.mybatis.spring.SqlSessionFactoryBean">
    <!-- your configuration -->
    <property name="typeHandlersPackage" value="com.github.javaplugs.mybatis" />
</bean>
```
