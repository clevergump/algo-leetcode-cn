package com.leetcodecn.common.helper;

import java.util.ArrayList;
import java.util.Iterator;


public class SinglyLinkedListFactory {

    public static ListNode createSinglyLinkedList(int... intValues){
        if (intValues == null) return null;

        Builder builder = getBuilder();
        for(int value: intValues){
            builder.setNextValue(value);
        }
        return builder.build();
    }

    private static Builder getBuilder(){
        return new Builder();
    }

    private static class Builder {
        Integer headValue = null;
        ArrayList<Integer> nonHeadValues = new ArrayList<>();


        public Builder() {
        }

        public Builder setNextValue(int next){
            if (headValue == null) {
                headValue = next;
            } else {
                nonHeadValues.add(next);
            }
            return this;
        }

        public ListNode build(){
            if (headValue == null) return null;

            ListNode headNode = new ListNode(headValue);
            ListNode curHandingNode = headNode;
            Iterator<Integer> iterator = nonHeadValues.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                curHandingNode = curHandingNode.setNextNode(next);
            }
            return headNode;
        }
    }
}
