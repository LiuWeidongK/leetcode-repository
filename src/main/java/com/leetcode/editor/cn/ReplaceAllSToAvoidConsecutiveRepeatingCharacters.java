package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>给你一个仅包含小写英文字母和 <code>&#39;?&#39;</code> 字符的字符串 <code>s</code>，请你将所有的 <code>&#39;?&#39;</code>
 * 转换为若干小写字母，使最终的字符串不包含任何 <strong>连续重复</strong> 的字符。</p>
 *
 * <p>注意：你 <strong>不能</strong> 修改非 <code>&#39;?&#39;</code> 字符。</p>
 *
 * <p>题目测试用例保证 <strong>除</strong> <code>&#39;?&#39;</code> 字符 <strong>之外</strong>，不存在连续重复的字符。</p>
 *
 * <p>在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>s = &quot;?zs&quot;
 * <strong>输出：</strong>&quot;azs&quot;
 * <strong>解释：</strong>该示例共有 25 种解决方案，从 &quot;azs&quot; 到 &quot;yzs&quot; 都是符合题目要求的。只有 &quot;z&quot; 是无效的修改，因为字符串 &quot;zzs&quot; 中有连续重复的两个 &#39;z&#39; 。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>s = &quot;ubv?w&quot;
 * <strong>输出：</strong>&quot;ubvaw&quot;
 * <strong>解释：</strong>该示例共有 24 种解决方案，只有替换成 &quot;v&quot; 和 &quot;w&quot; 不符合题目要求。因为 &quot;ubvvw&quot; 和 &quot;ubvww&quot; 都包含连续重复的字符。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>s = &quot;j?qg??b&quot;
 * <strong>输出：</strong>&quot;jaqgacb&quot;
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre><strong>输入：</strong>s = &quot;??yw?ipkj?&quot;
 * <strong>输出：</strong>&quot;acywaipkja&quot;
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>
 * <p><code>1 &lt;= s.length&nbsp;&lt;= 100</code></p>
 * </li>
 * <li>
 * <p><code>s</code> 仅包含小写英文字母和 <code>&#39;?&#39;</code> 字符</p>
 * </li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 95</li><li>👎 0</li></div>
 */
public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {

  public static void main(String[] args) {
    Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
    System.out.println(solution.modifyString("?"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private final Map<Character, Character> mapping = generateMapping();

    public String modifyString(String s) {

      if (s.length() == 1) {
        return "a";
      }

      char[] chars = s.toCharArray();

      for (int i = 0; i < chars.length; i++) {

        if (chars[i] != '?') {
          continue;
        }

        if (i == 0) {
          chars[i] = mapping.get(chars[i + 1]);
          continue;
        }

        if (i + 1 == chars.length) {
          chars[i] = mapping.get(chars[i - 1]);
          continue;
        }

        if (chars[i - 1] == chars[i + 1]) {
          chars[i] = mapping.get(chars[i - 1]);
          continue;
        }

        // j?q
        Character fromLeft = mapping.get(chars[i - 1]);
        if (fromLeft == chars[i + 1]) {
          chars[i] = mapping.get(chars[i + 1]);
          continue;
        }
        chars[i] = fromLeft;
      }

      return new String(chars);
    }

    private Map<Character, Character> generateMapping() {

      Map<Character, Character> mapping = new HashMap<>();

      for (char c = 'a'; c <= 'z'; c++) {
        char v = c + 1 > 'z' ? 'a' : (char) (c + 1);
        mapping.put(c, v);
      }
      mapping.put('?', 'a');
      return mapping;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}