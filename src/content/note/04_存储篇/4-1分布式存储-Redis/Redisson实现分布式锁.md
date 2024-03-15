---
pubDatetime: 2023-11-26T00:00:00Z
title: Redis
slug: Redis
tags:
  - "Redis"
  - "分布式锁"
---
# Redisson实现分布式锁

# 1. 锁的类型 

* 排他锁 ： 不允许多个程序（线程/进程），同时访问某个共享资源
* 共享锁

# 2. 分布式锁

* 跨进程实现共享资源的互斥
* 分布式锁的实现方案
  * redis
  * mysql
  * zookeeper
  * ...

# 3. Redisson实现分布式锁的原理

## 3.1 Redisson实现分布式锁关键点

* Lua脚本（实现锁的抢占或获取）
* HashedWheel (时间轮) 实现过期的自动续期
* Pub/Sub机制（当获得锁的线程释放之后，通知处于阻塞状态下的线程去抢占锁）

## 3.2 Redisson源码分析

RedissonLock.tryLock

tryAcquire

tryLockInnerAsync

unlock释放锁流程

# 4.Redisson实现分布式锁源码分析

## Redis中的发布/订阅机制

```java
# 发布
publish channel.1 "hello world"
# 订阅    
subscribe channel.1 
```

# 5. Lua脚本

Lua的下载与安装

```lua
array = {"zhangsan","lisi"}
for i = 0,2 do 
print(array[i])
end 
```

![1710340382294](C:\Users\lzc\AppData\Local\Temp\1710340382294.png)

## Redis中调用Lua脚本

```redis
eval "return redis.call('set', KEYS[1], ARGV[1])" 1 luaKey hello 
```

![1710340852580](C:\Users\lzc\AppData\Local\Temp\1710340852580.png)

# 6.时间轮机制