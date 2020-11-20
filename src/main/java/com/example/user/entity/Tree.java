package com.example.user.entity;

import java.io.Serializable;
import java.util.List;

public class Tree  implements Serializable {
     
     /**
     *
     */
     private static final long serialVersionUID = 6995928021657013792L;

     private String key;//节点key

     private String title;//节点名称

     private String parentKey;//节点父id

     private String iconCls = "folder";//节点样式，默认即可

     private Boolean isLeaf = true;//是否为叶子节点，true表示是叶子节点，false表示不是叶子节点

     private Boolean expanded = true; //是否展开，默认true,展开

     private List<Tree> children;//孩子节点

     /**
      * @取得id的值
      * @return the id
      */
     public String getKey() {
         return key;
     }

     /**
      * @设置id的值
      * @param id the id to set
      */
     public void setKey(String key) {
         this.key = key;
     }

     /**
      * 取得title的值
      *
      * @return  title值
      */

     public String getTitle() {
         return title;
     }

     /**
      * 设定title的值
      *
      * @param  title 设定值
      */
     public void setTitle(String title) {
         this.title = title;
     }

     /**
      * @取得parentId的值
      * @return the parentId
      */
     public String getParentKey() {
         return parentKey;
     }

     /**
      * @设置parentId的值
      * @param parentId the parentId to set
      */
     public void setParentKey(String parentKey) {
         this.parentKey = parentKey;
     }

     /**
      * @取得iconCls的值
      * @return the iconCls
      */
     public String getIconCls() {
         return iconCls;
     }

     /**
      * @设置iconCls的值
      * @param iconCls the iconCls to set
      */
     public void setIconCls(String iconCls) {
         this.iconCls = iconCls;
     }

     /**
      * @取得isLeaf的值
      * @return the isLeaf
      */
     public Boolean getIsLeaf() {
         return isLeaf;
     }

     /**
      * @设置isLeaf的值
      * @param isLeaf the isLeaf to set
      */
     public void setIsLeaf(Boolean isLeaf) {
         this.isLeaf = isLeaf;
     }

     /**
      * @取得expanded的值
      * @return the expanded
      */
     public Boolean getExpanded() {
         return expanded;
     }

     /**
      * @设置expanded的值
      * @param expanded the expanded to set
      */
     public void setExpanded(Boolean expanded) {
         this.expanded = expanded;
     }

     /**
      * @取得children的值
      * @return the children
      */
     public List<Tree> getChildren() {
         return children;
     }

     /**
      * @设置children的值
      * @param children the children to set
      */
     public void setChildren(List<Tree> children) {
         this.children = children;
     }

}
