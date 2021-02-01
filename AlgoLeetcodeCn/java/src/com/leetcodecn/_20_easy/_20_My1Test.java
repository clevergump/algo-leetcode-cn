package com.leetcodecn._20_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _20_My1Test {

    @Test
    void isValid() {
        Assertions.assertEquals(false, new _20_My1().isValid("("));
        Assertions.assertEquals(false, new _20_My1().isValid(")"));
        Assertions.assertEquals(false, new _20_My1().isValid("["));
        Assertions.assertEquals(false, new _20_My1().isValid("]"));
        Assertions.assertEquals(false, new _20_My1().isValid("{"));
        Assertions.assertEquals(false, new _20_My1().isValid("}"));
        Assertions.assertEquals(true, new _20_My1().isValid("()"));
        Assertions.assertEquals(true, new _20_My1().isValid("[]"));
        Assertions.assertEquals(true, new _20_My1().isValid("{}"));
        Assertions.assertEquals(false, new _20_My1().isValid("(["));
        Assertions.assertEquals(false, new _20_My1().isValid("(]"));
        Assertions.assertEquals(false, new _20_My1().isValid("])"));

        Assertions.assertEquals(true, new _20_My1().isValid("([{()}])"));
        Assertions.assertEquals(false, new _20_My1().isValid("(][)"));
        Assertions.assertEquals(false, new _20_My1().isValid("[(]}"));
        Assertions.assertEquals(false, new _20_My1().isValid("[{]}"));
        Assertions.assertEquals(false, new _20_My1().isValid(")))[]"));
        Assertions.assertEquals(false, new _20_My1().isValid(")))[]}}}"));
        Assertions.assertEquals(false, new _20_My1().isValid("))])]}}]"));
    }


//    @Test
//    void isValid() {
//        Assertions.assertEquals(false, new _20_My1().isValid("("));
//        Assertions.assertEquals(true, new _20_My1().isValid(")"));
//        Assertions.assertEquals(false, new _20_My1().isValid("["));
//        Assertions.assertEquals(true, new _20_My1().isValid("]"));
//        Assertions.assertEquals(false, new _20_My1().isValid("{"));
//        Assertions.assertEquals(true, new _20_My1().isValid("}"));
//        Assertions.assertEquals(true, new _20_My1().isValid("()"));
//        Assertions.assertEquals(true, new _20_My1().isValid("[]"));
//        Assertions.assertEquals(true, new _20_My1().isValid("{}"));
//        Assertions.assertEquals(false, new _20_My1().isValid("(["));
//        Assertions.assertEquals(false, new _20_My1().isValid("(]"));
//        Assertions.assertEquals(true, new _20_My1().isValid("])"));
//
//        Assertions.assertEquals(true, new _20_My1().isValid("([{()}])"));
//        Assertions.assertEquals(false, new _20_My1().isValid("(][)"));
//        Assertions.assertEquals(false, new _20_My1().isValid("[(]}"));
//        Assertions.assertEquals(true, new _20_My1().isValid(")))[]"));
//        Assertions.assertEquals(true, new _20_My1().isValid(")))[]}}}"));
//        Assertions.assertEquals(true, new _20_My1().isValid("))])]}}]"));
//    }
}