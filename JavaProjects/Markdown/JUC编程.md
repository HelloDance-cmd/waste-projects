# `JUC` 编程

- `Thread.currentThread().isInterrupted()` 判断是否有终端标记
- `Thread.interrupted()`  判断是否有中断标记并且清除中断标记

```java
//  创建一个线程
for (int i = 0; i < 10; i++)
{
    Thread thread = new Thread(() ->
    {
        if(Thread.interrupted()) // 判断是否有中断标记并且清除标记
            System.out.println(Thread.currentThread().isInterrupted()); // 查看终端标记状态

        System.out.println("Current " + Thread.currentThread().getName());
    });

    thread.start();
    thread.interrupt();  // 执行终端
}

System.out.println("Program finished.");
```

## 守护线程

默认情况下创建的线程都是用户线程（普通线程），**进程需要等待所有的线程执行完毕**后进程才会结束

## 线程状态

```md
New->Runnable
	Block	(synchronized)  notifly
	Waiting	 (Wait, Join, LockSupport.park)
	Timed Waiting (Sleep, Wait, LockSupport.park())
		-> Terminate
```

只有这三种状态可以
