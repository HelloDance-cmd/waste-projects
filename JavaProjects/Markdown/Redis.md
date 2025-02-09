# Redis

- Redis是一个NoSQL数据库（键值对）
- Redis没有Windows版本，可以通过其他第三方安装

## Redis命令行

Redis有很多的类型

基本类型

- **String**（不可以超过512M）
- **Hash**
- **List**
- **Set**
- **SortedSet**

特殊类型

- GEO
- BitMap
- HyperLog

>```bash
>127.0.0.1:6379> help @list
>```
>
>查询相关的**组**命令

https://redis.io/docs/latest/commands/

## Redis的通用命令

1. KEYS:查看符合模板的所有key，不建议在生产环境设备上使用
2. DEL:删除一个指定的key
3. EXISTS:判断key是否存在
4. EXPIRE给一个key设置有效期，有效期到期时该key会被自动删除
5. TTL 查看key还有多少有效期

## String命令

String的常见命令有:

1. SET:添加或者修改已经存在的一个String类型的键值对
2. GET:根据key获取String类型的value
3. MSET:批量添加多个String类型的键值对
4. MGET:根据多个key获取多个String类型的value
5. INCR:让一个整型的key自增1
6. INCRBY:让一个整型的key自增并指定步长，例如:incrby num 2 让num值自增
7. INCRBYFLOAT:让一个浮点类型的数字自增并指定步长
8. SETNX:添加一个String类型的键值对，前提是这个key不存在，否则不执行
9. SETEX:添加一个String类型的键值对，并且指定有效期

> 可以按冒号分层类似与MySQL表的概念
>
> brick:user:1

```bash
set brick:user:1 "{'name': 'jack', age: 1}"
```

## HASH类型

## List类型

> 其内部是一个双向链表

List的常见命令有:

- LPUSH key element..:向列表左侧插入一个或多个元素
- LPOP key:移除并返回列表左侧的第一个元素，没有则返回nil
- RPUSH key element…:向列表右侧插入一个或多个元素
- RPOP key:移除并返回列表右侧的第一个元素
- LRANGE key starend:返回一段角标范围内的所有元素
- BLPOP和BRPOP:与LPOP和RPOP类似，只不过在没有元素时等待指定时间，而不是直接返回nil

## Set类型

- 无序
- 元素不重复
- 查找速度快
- 基于HASH结构存储

Set的常见命令有：

向set中添加一个或多个元素

1. SADD key member ...:
2. SREM key member...:移除set中的指定元素
3. SCARD key:返回set中元素的个数
4. SISMEMBER key member:判断一个元素是否存在于set中
5. SMEMBERS:获取set中的所有元素
6. SINTER key1 key2...:求key1与key2的交集
7. SDlFF key1 key2 ...:求key1与key2的差集
8. SUNION key1 key2..:求key1和key2的并集

## SortedSet类型

Sortedset的常见命令有:

- ZADD key score member:添加一个或多个元素到sortedset，如果已经存在则更新其score值
- ZREM key member:删除sorted set中的一个指定元素
- ZSCORE key member:获取sorted set中的指定元素的score值。
- ZRANK key member:获取sorted set 中的指定元素的排名
- ZCARD key:获取sortedset中的元素个数
- ZCOUNT key min max:统计score值在给定范围内的所有元素的个数
- ZINCRBY key increment member:让sorted set中的指定元素自增，步长为指定的increment值
- ZRANGE key min max:按照score排序后，获取指定排名范围内的元素
- ZRANGEBYSCORE key min max:按照score排序后，获取指定score范围内的元素
- ZDIFF、ZINTER、ZUNION:求差集、交集、并集

> 如果希望降序则在命令后加上 REV (**Reverse**)即可
>
> 例如：ZREVADD

# Redis的Java客户端

```java
Jedis jedis = new Jedis("127.0.0.1", 6379);
jedis.set(name, value);
jedis.hset(name, field, value);

jedis.close();
```

Jedis的连接池







