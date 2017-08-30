# -*- coding: utf-8 -*-
#list practice

#1. 使用for打印1-20
for i in range(1,101):
    print(i)
#2. 求list中最大，最小及总和
score = list(range(1,101))
print(min(score),max(score),sum(score))

#3. 列表切片
testList = list(range(1,20,2))
print(testList[:])
print(3 in testList)  #in语句很有用，判断3是否在列表里

#4 dict
aliens ={}
aliens['color'] = 'green'
aliens['points'] = 5
print(aliens)

#5
usr={
    'usrname':'efermi',
    'first':'enrico',
    'last':'fermi',
}
for key,value in usr.items():
    print("\nkey: "+ key)
    print("value: "+ value)

#7 input && while
