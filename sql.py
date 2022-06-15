# -*- coding: utf-8 -*-
"""
Created on Tue Jun 14 15:16:12 2022

@author: olive lam
"""
import numpy as np;
import random

for i in range(25):
    vid = i + 25
    title = random.randint(10,1000)
    fieldid = random.randint(0,5)
    uploader = random.randint(0,10)
    year = random.randint(2020, 2022)
    month = random.randint(1, 12)
    day = random.randint(1, 28)
    date = str(year)  + '-'+ str(month) + '-' + str(day)
    sql = 'INSERT INTO video (videoid, title, fieldid, uploadtime, uploader) VALUES (';
    
    sql= sql + '\'' + str(vid) + '\',\'' + str(title) + '\',\'' + str(fieldid) + '\',\'' + date + '\',\'' + str(uploader) + '\');';
    #print(sql);

s = set()
for i in range(100):
    username = random.randint(0, 20)
    likeid = random.randint(24, 49)
    key = (username, likeid)
    if (key in s):
        continue
    s.add(key)
    sql = "INSERT INTO user_like (username, likeid, liketype) VALUES (\'" + str(username) + '\',\'' + str(likeid) + '\',\'0\');'
    #print(sql)


for i in range(14):
    username = str(i + 7)
    admin = str(random.randint(0, 1))
    sql = "INSERT INTO userinfo (`username`, `admin`) VALUES (\'"+ username +"\', \'" + admin + "\');"
    #print(sql)

s = set()
for i in range(20):
    f1 = random.randint(0, 20)
    f2 = random.randint(0, 20)
    key = (f1, f2)
    if (key in s):
        continue
    s.add(key)
    
    sql = "INSERT INTO `follow` (`usernamefollowed`, `usernamefollower`) VALUES (\'"+ str(f1) +"\', \'" + str(f2) + "\');"
    #print(sql)


for i in range(40):
    cid = str(i + 29)
    username = str(random.randint(0, 20))
    ctoid = str(random.randint(25, 49))
    
    sql = 'INSERT INTO `echart`.`user_comment` (`commentid`, `username`, `commenttoid`, `commenttype`) VALUES (\'' + cid + '\', \'' + username + '\', \''+ ctoid +'\', \'0\');'
    print(sql)
'''
for i in range(20):
    bid = str(i + 3)
    username = str(random.randint(0, 20))
    vid = str(random.randint(0, 24))
    time = str(random.randint(0,60))
    sql = "INSERT INTO `echart`.`barrage` (`barrageid`, `username`, `videoid`, `time`) VALUES (\'" + bid + "\', \'" + username +"\', \'" + vid +"\', \'" + time + "\');"
    print(sql)
'''  

    