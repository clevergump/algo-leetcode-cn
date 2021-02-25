package com.leetcodecn._58_easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _58_ReverseTraversal1Test {

    @Test
    void lengthOfLastWord() {
        // 1. --全部是字母, 无空格
        Assertions.assertEquals(3, _58_ReverseTraversal1_NotBest.lengthOfLastWord("aaa"));
        // 2. --全部是空格, 无字母
        Assertions.assertEquals(0, _58_ReverseTraversal1_NotBest.lengthOfLastWord(" "));

        // 3. --同时包含空格和字母

        // 空格仅在最前边(1个空格)
        Assertions.assertEquals(3, _58_ReverseTraversal1_NotBest.lengthOfLastWord(" aaa"));
        // 空格仅在最前边(多个空格)
        Assertions.assertEquals(3, _58_ReverseTraversal1_NotBest.lengthOfLastWord("  aaa"));
        // 空格仅在中间(1个空格)
        Assertions.assertEquals(5, _58_ReverseTraversal1_NotBest.lengthOfLastWord("Hello World"));
        // 空格仅在中间(多个空格)
        Assertions.assertEquals(5, _58_ReverseTraversal1_NotBest.lengthOfLastWord("Hello  World"));
        // 空格仅在最后面(1个空格)
        Assertions.assertEquals(3, _58_ReverseTraversal1_NotBest.lengthOfLastWord("aaa "));
        // 空格仅在最后面(多个空格)
        Assertions.assertEquals(3, _58_ReverseTraversal1_NotBest.lengthOfLastWord("aaa   "));
        // 空格同时在最前面和中间
        Assertions.assertEquals(5, _58_ReverseTraversal1_NotBest.lengthOfLastWord("  Hello  World"));
        // 空格同时在最前面和最后面
        Assertions.assertEquals(3, _58_ReverseTraversal1_NotBest.lengthOfLastWord("  aaa   "));
        // 空格同时在中间和最后面
        Assertions.assertEquals(5, _58_ReverseTraversal1_NotBest.lengthOfLastWord("Hello  World  "));
        // 空格同时在最前面, 中间和最后面
        Assertions.assertEquals(5, _58_ReverseTraversal1_NotBest.lengthOfLastWord("   Hello  World  "));
    }
}