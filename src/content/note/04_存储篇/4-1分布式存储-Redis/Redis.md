---
pubDatetime: 2023-11-26T00:00:00Z
title: Redis
slug: Redis
tags:
  - "Redis"
  - "概念"
---

虚拟机的网络配置先看这个：

VMware+Centos7 静态IP设置方法

姊妹篇：

[Redis6.0.9一主二从Sentinel监控配置

](https://gper.club/articles/7e7e7f7ff3g5bgccg68)

CentOS 7 单机安装Redis Cluster6.0.9（3主3从伪集群）

阿里云CentOS7 Docker安装Redis

!! 由于基础环境差异，安装过程可能遇到各种各样的问题，不要慌，根据错误提示解决即可。

安装路径：/usr/local/soft/

1、下载redis

下载地址在：redis.io 首页



如果从官网下载慢，可以把链接贴到迅雷下载，再传到虚拟机：

    cd /usr/local/soft/
    wget https://download.redis.io/releases/redis-6.0.9.tar.gz

2、解压压缩包

    tar -zxvf redis-6.0.9.tar.gz

3、安装gcc依赖

Redis是C语言编写的，编译需要GCC。

Redis6.x.x版本支持了多线程，需要gcc的版本大于4.9，但是CentOS7的默认版本是4.8.5。

查看gcc的版本：

    gcc -v

升级gcc版本：

    yum -y install centos-release-scl
    
    yum -y install devtoolset-9-gcc devtoolset-9-gcc-c++ devtoolset-9-binutils
    
    scl enable devtoolset-9 bash
    
    echo "source /opt/rh/devtoolset-9/enable" >>/etc/profile

确认gcc的版本（在同一个窗口中！）：

    gcc -v

4、编译安装

    cd redis-6.0.9/src
    make install

安装成功的结果是src目录下面出现服务端和客户端的脚本

redis-server

redis-cli

redis-sentinel

5、修改配置文件

默认的配置文件是/usr/local/soft/redis-6.0.9/redis.conf

后台启动，不然窗口一关服务就挂了

    daemonize no

改成

    daemonize yes

下面一行必须改成 bind 0.0.0.0 或注释，否则只能在本机访问

    bind 127.0.0.1 

如果需要密码访问，取消requirepass的注释，在外网（比如阿里云）这个必须要配置！

    requirepass yourpassword

6、使用指定配置文件启动Redis

    /usr/local/soft/redis-6.0.9/src/redis-server /usr/local/soft/redis-6.0.9/redis.conf

查看端口是否启动成功：

    netstat -an|grep 6379

7、进入客户端

    /usr/local/soft/redis-6.0.9/src/redis-cli

8、停止redis（在客户端中）

    redis> shutdown

或

    ps -aux | grep redis
    kill -9 xxxx

9、配置别名的步骤

    vim ~/.bashrc

添加两行：

    alias redis='/usr/local/soft/redis-6.0.9/src/redis-server /usr/local/soft/redis-6.0.9/redis.conf'
    alias rcli='/usr/local/soft/redis-6.0.9/src/redis-cli'

编译生效：

    source ~/.bashrc

这样就可以用redis启动服务，rcli进入客户端了

附赠

一个Win7可用的Redis可视化客户端（redis-desktop-manager-0.8.3.3850）

最后一个免费版本是0.9.3.817，后面都要付费了，不升级不用付费

链接：https://pan.baidu.com/s/1m6QoUaU0AKLfiXGhSNDJww

提取码：ewa0

附旧版本教程：

CentOS7安装Redis 5.0.5单实例



