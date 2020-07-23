# STL-Learning

## C-vector

### 构造

```c
// c++11 初始化器列表语法：
    std::vector<std::string> words1 {"the", "frogurt", "is", "also", "cursed"};
    std::cout << "words1: " << words1 << '\n';
 
    // words2 == words1
    std::vector<std::string> words2(words1.begin(), words1.end());
    std::cout << "words2: " << words2 << '\n';
 
    // words3 == words1
    std::vector<std::string> words3(words1);
    std::cout << "words3: " << words3 << '\n';
 
    // words4 为 {"Mo", "Mo", "Mo", "Mo", "Mo"}
    std::vector<std::string> words4(5, "Mo");
    std::cout << "words4: " << words4 << '\n';
```



### 修改器

#### clear

```c
void clear();
//容器擦除所有元素
```



#### insert

```c
iterator insert( iterator pos, const T& value );
//在pos前插入值value.
```



#### erase

```c
iterator  erase( iterator pos );
 //移除迭代器对应的元素
```



```c
iterator erase( iterator first, iterator last );
//移除范围 [first; last)的元素
```



#### push_back

```c
void push_back( T&& value );
//给定元素 value 到容器尾
```



#### pop_back

```c
void pop_back();
//移除容器的最末元素. 不返回值
```

#### swap

```
void swap( vector& other );
//交换
std::vector<int> v1{1, 2, 3};
std::vector<int> v2{7, 8, 9};

v2.swap(v1);
//此时:v1: 7 8 9
//	v2: 1 2 3
```



### 容量

#### empty

```c
bool empty() const;
//若容器为空则为 true ，否则为 false
```



#### size

```c
int size();
//返回容纳的元素数
```



#### max_size

```c
int max_size();
//返回可容纳的最大个数
```



#### capacity

```c
size_type capacity() const
//返回容器当前已为之分配空间的元素数。
```

;



### 元素访问

#### at

```c
std::vector<int> data = { 1, 2, 4, 5, 5, 6 };
data.at(1) = 88;
std::cout << data.at(2);
 //返回指定下标的元素(从零开始)
//用法同[]
```



#### front

```c
vector<char> letters;
cout<<letters.front() ;
//访问第一个元素
```



#### back

```c
vector<char> letters;
cout<<letters.back() ;
//访问最后一个元素
```



#### begin&end

```c
iterator begin();
//返回首元素的迭代器
iterator end();
//返回末尾元素的后面一个的迭代器
```



#### rbegin&rend

```c
reverse_iterator rbegin();
//返回末尾元素的迭代器
reverse_iterator rend();
//返回首元素的前面一个的迭代器
```



### 其他操作

#### 遍历vector中元素

可使用这种方法

```
std::vector<char> characters;

characters.assign({'\n', 'C', '+', '+', '1', '1', '\n'});

for (char c : characters) {
std::cout << c;
}
```





## C-map

`std::map` 是有序键值对容器，它的元素的键是唯一的。用比较函数 `Compare` 排序键。搜索、移除和插入操作拥有对数复杂度。 map 通常实现为[红黑树](https://en.wikipedia.org/wiki/Red–black_tree)

### 元素访问

#### at

```c
T& at( const Key& key );

//返回到拥有等于 key 的关键的元素被映射值的引用。若无这种元素，则抛出 std::out_of_range 类型异常
//同[],但[]若查找失败会插入

//复杂度
//与容器大小成对数。
```

#### pair

map中元素的数据结构为pair, 因此访问需要使用

```c
std::map<char, int> m {{'a', 27}, {'b', 3}, {'c', 1}};
for (const auto &pair : m) {
        std::cout << pair.first << ": " << pair.second << '\n';
    }
//或者
for (auto it = num_map.begin(); it != num_map.end(); ++it) {
    std::cout << it->first << ", " << it->second << '\n';
  }
```

#### begin & end

返回指向开头/末尾的迭代器

顺序为key的排序

### 容量

#### empty

```c
bool empty() const;
//若容器为空则为 true ，否则为 false
```



#### size

```c
int size();
//返回容纳的元素数
```



#### max_size

```c
int max_size();
//返回可容纳的最大个数
```



### 修改

#### clear

```c
void clear();
//容器擦除所有元素
```



#### insert

```c
std::pair<iterator,bool> insert( const value_type& value );
//参数为一个pair
//返回值也是一个pair, 由迭代器和是否插入成功的标识组成
karasunoPlayerHeights.insert({"Hinata", 162.8});

```

#### insert_or_assign

```c
pair<iterator, bool> insert_or_assign(const key_type& k, M&& obj);
//若key重复, 替换之
//注意这个的传入参数不是pair了
std::map<std::string, std::string> myMap;
myMap.insert_or_assign("a", "apple"     );
myMap.insert_or_assign("b", "bannana"   );
myMap.insert_or_assign("c", "cherry"    );
myMap.insert_or_assign("c", "clementine");
```



#### erase

```c
iterator  erase( iterator pos );
 //移除位于 pos 的元素。返回移除后的下一个元素迭代器
//注  C98返回void
```

```c
iterator  erase( iterator first, iterator last );
//移除范围 [first; last)的元素.返回移除后的下一个元素迭代器
//注  C98返回void
```

```c
size_type erase( const key_type& key );
```



### 查找

#### find

```c
iterator find( const Key& key );
//寻找键等于 key 的的元素。
//返回指向键等于 key 的元素的迭代器。若找不到这种元素，则返回尾后迭代器。
```
