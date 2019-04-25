悲观锁(sync)

重量锁，影响效率，可能会死锁



CAS（compare and swap），乐观锁机制

原理：利用了现代处理器都支持的CAS的指令

拿变量值

计算新值

比较旧值和内存中的值

如果相同，没有线程修改，则设入新值

CAS的问题：

- ABA问题

  加入版本号

- 开销问题

- 只能保证一个共享变量的原子操作



ABA问题解决

更新引用类型：

AtomicMarkableReferced      只关心是否被改变

AtomicStampedReferced	  不 只关心是否被改变，还关心被改变了多少次



AtomicReferce原则上只能保证一个地址的原子性操作，为了修改多个值，放在一个引用类型中