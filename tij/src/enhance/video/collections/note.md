Collection:存储的数据不唯一、无序的对象
List：存储的数据不唯一、有序的对象
Set：存储的数据唯一、无序的对象

唯一：不可重复，只能有一个
有序：不是排序的意思。是输入顺序是否与输出顺序一致。

Collection
 - List
    - ArrayList
    - LinkedList
 - Set
    - HashSet,底层实现是HashMap
    - TreeSet，底层实现是TreeMap

Map
- HashMap
- TreeMap

HashXxx：底层借助了“哈希表”的数据结构，默认不支持排序
TreeXxx：底层借助“红黑树/排序二叉树etc”的数据结构，默认支持排序

set中的remove()为什么只能根据内容删，不能按下标来？因为set是无序的，不知道要删除元素
的下标到底是谁。

-----
Collection 和 Map直接没什么关系。
- Map是个顶级接口
- Collection 继承了顶级接口Iterable
