package com.example.user.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    public static void main(String[] args) {

        List<TreeTemp> treeTempList = new ArrayList<>();

        TreeTemp temp;

        for(int i=0; i<3; i++) {
            temp = new TreeTemp();
            temp.setId(i + "");
            temp.setName("第一级");
            treeTempList.add(temp);
        }

        for(int i=0; i<3; i++) {
            temp = new TreeTemp();
            temp.setId(0 + "" + i);
            temp.setName("第二级");
            temp.setPid(treeTempList.get(0).getId());
            treeTempList.add(temp);
        }

        for(int i=0; i<3; i++) {
            temp = new TreeTemp();
            temp.setId(0 + "" + 0 + "" + i);
            temp.setName("第三级");
            temp.setPid(treeTempList.get(3).getId());
            treeTempList.add(temp);
        }

        for(int i=0; i<3; i++) {
            temp = new TreeTemp();
            temp.setId(1 + "" + i);
            temp.setName("第二级");
            temp.setPid(treeTempList.get(1).getId());
            treeTempList.add(temp);
        }

        System.out.println(treeTempList.toString());

        //把这个list转换为树啊
        for(int i=0; i<treeTempList.size(); i++) {

        }

    }
}
