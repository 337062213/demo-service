package com.example.user.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {

    public static List<DefaultTree> build(List<DefaultTree> trees , String pid) {
        Map<String, List<DefaultTree>> map = new HashMap<>();
        for (DefaultTree t : trees) {
            String parentId = t.getPid();
            List<DefaultTree> childrens = map.get(parentId);
            if (childrens == null) {
                childrens = new ArrayList<>();
                map.put(parentId, childrens);
            }
            childrens.add(t);
        }
        List<DefaultTree> treeList = new ArrayList<>();
        childBuild(map,pid,treeList);
        return  treeList ;
    }

    private  static <T extends DefaultTree> void  childBuild(Map<String, List<T>> map, String pid , List<DefaultTree> treeList){
        List<T> tList = map.get(pid);
        if(!CollectionUtils.isEmpty(tList)){
            for(T tree : tList){
                treeList.add(tree);
                childBuild(map ,tree.getId(), tree.getChildren());
            }
        }

    }

    public static void main(String[] args) {
        List<DefaultTree> treeTempList = new ArrayList<>();

        DefaultTree temp;

        for(int i=0; i<3; i++) {
            temp = new DefaultTree();
            temp.setId(i + "");
            temp.setLabel("第一级");
            treeTempList.add(temp);
        }

        for(int i=0; i<3; i++) {
            temp = new DefaultTree();
            temp.setId(0 + "" + i);
            temp.setLabel("第二级");
            temp.setPid(treeTempList.get(0).getId());
            treeTempList.add(temp);
        }

        for(int i=0; i<3; i++) {
            temp = new DefaultTree();
            temp.setId(0 + "" + 0 + "" + i);
            temp.setLabel("第三级");
            temp.setPid(treeTempList.get(3).getId());
            treeTempList.add(temp);
        }

        for(int i=0; i<3; i++) {
            temp = new DefaultTree();
            temp.setId(1 + "" + i);
            temp.setLabel("第二级");
            temp.setPid(treeTempList.get(1).getId());
            treeTempList.add(temp);
        }

        System.out.println(TreeUtil.build(treeTempList, 0+""));
    }

}
