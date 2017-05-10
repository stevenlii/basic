## hashcode&eqs
浅谈Java中的hashcode方法 - ImportNew
http://www.importnew.com/18851.html
Hashcode的作用 - 差点先生 - ITeye技术网站
http://c610367182.iteye.com/blog/1930676

hashcode是为了算元素存在的物理地址（引用变量）
如果hash 相同，则可能是发生了碰撞，所以需要重写eqs方法！
这点明白来源于hashmap的entry机制，如果key的hash相同，则表明这个对象在同一数组里的同一个entry里面，只是如果key eqs，那么是同一对象，如果key不同，则在put的时候放在链表表头！

所以会有：

Java对于eqauls方法和hashCode方法是这样规定的： 
           1、如果两个对象相等，那么它们的hashCode值一定要相等； 
           原因:比较两个对象的时候,首先根据他们的hashcode去hash表中找他的对象，当两个对象的hashcode相同,那么就是说他们这两个对象放在Hash表中的同一个key上,那么他们一定在这个key上的链表上。那么此时就只能根据Object的equal方法来比较这个对象是否equal。当两个对象的hashcode不同的话，肯定他们不能equal. 
           2、如果两个对象的hashCode相等，它们并不一定相等。 
           
 原因：
 以java.lang.Object来理解,JVM每new一个Object,它都会将这个Object丢到一个Hash哈希表中去,这样的话,下次做Object的比较或者取这个对象的时候,它会根据对象的hashcode再从Hash表中取这个对象。这样做的目的是提高取对象的效率。具体过程是这样: 
1.new Object(),JVM根据这个对象的Hashcode值,放入到对应的Hash表对应的Key上,如果不同的对象确产生了相同的hash值,也就是发生了Hash key相同导致冲突的情况,那么就在这个Hash key的地方产生一个链表,将所有产生相同hashcode的对象放到这个单链表上去,串在一起。 
2.比较两个对象的时候,首先根据他们的hashcode去hash表中找他的对象,当两个对象的hashcode相同,那么就是说他们这两个对象放在Hash表中的同一个key上,那么他们一定在这个key上的链表上。那么此时就只能根据Object的equal方法来比较这个对象是否equal。当两个对象的hashcode不同的话，肯定他们不能equal. 

 
所以会有：
Java采用了哈希表的原理。哈希算法也称为散列算法，是将数据依特定算法直接指定到一个地址上。这样一来，当集合要添加新的元素时，先调用这个元素的hashCode方法，就一下子能定位到它应该放置的物理位置上。如果这个位置上没有元素，它就可以 直接存储在这个位置上，不用再进行任何比较了；如果这个位置上已经有元素了，就调用它的equals方法与新元素进行比较，相同的话就不存了；不相同，也就是发生了Hash key相同导致冲突的情况,那么就在这个Hash key的地方产生一个链表,将所有产生相同hashcode的对象放到这个单链表上去,串在一起。所以这里存在一个冲突解决的问题（很少出现）。这样一来实际调用equals方法的次数就大大降低了，几乎只需要一两次。 

所以为什么重写了eqs方法，最好重写hash，因为怕碰撞啊

所以会有：
 比较Integer的两个对象时，如果不重写eqs方法，比较结果肯定为false，需要使用 .intvalue（）方法
 例子见：Integer$eqs<K,V>
 
 		Integer i1 = 1;
		Integer i2 = 1;
		System.err.println(i1==i2);// true
		i1 = new Integer(1);
		i2 = new Integer(1);
		System.err.println(i1==i2);// false
		System.err.println(i1.equals(i2));// true
		System.err.println(i1.intValue()==i2);// true
		System.err.println(i1.intValue()==i2.intValue());// true
		
 i1.equals(i2)为true是因为最新jdk8是重写了eqs的
 public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return value == ((Integer)obj).intValue();
        }
        return false;
    }
 
 i1.intValue()==i2与i1.intValue()==i2.intValue() 相同会转化
 