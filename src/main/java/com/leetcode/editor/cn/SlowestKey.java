package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>LeetCode 设计了一款新式键盘，正在测试其可用性。测试人员将会点击一系列键（总计 <code>n</code> 个），每次一个。</p>
 *
 * <p>给你一个长度为 <code>n</code> 的字符串 <code>keysPressed</code> ，其中 <code>keysPressed[i]</code> 表示测试序列中第
 * <code>i</code> 个被按下的键。<code>releaseTimes</code> 是一个升序排列的列表，其中 <code>releaseTimes[i]</code> 表示松开第
 * <code>i</code> 个键的时间。字符串和数组的 <strong>下标都从 0 开始</strong> 。第 <code>0</code> 个键在时间为 <code>0</code>
 * 时被按下，接下来每个键都 <strong>恰好</strong> 在前一个键松开时被按下。</p>
 *
 * <p>测试人员想要找出按键 <strong>持续时间最长</strong> 的键。第 <code>i</code><sup> </sup>次按键的持续时间为
 * <code>releaseTimes[i] - releaseTimes[i - 1]</code> ，第 <code>0</code> 次按键的持续时间为
 * <code>releaseTimes[0]</code> 。</p>
 *
 * <p>注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。</p>
 *
 * <p>请返回按键 <strong>持续时间最长</strong> 的键，如果有多个这样的键，则返回 <strong>按字母顺序排列最大</strong> 的那个键。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * <strong>输出：</strong>"c"
 * <strong>解释：</strong>按键顺序和持续时间如下：
 * 按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
 * 按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
 * 按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
 * 按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
 * 按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
 * 'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * <strong>输出：</strong>"a"
 * <strong>解释：</strong>按键顺序和持续时间如下：
 * 按下 's' ，持续时间 12
 * 按下 'p' ，持续时间 23 - 12 = 11
 * 按下 'u' ，持续时间 36 - 23 = 13
 * 按下 'd' ，持续时间 46 - 36 = 10
 * 按下 'a' ，持续时间 62 - 46 = 16
 * 按键持续时间最长的键是 'a' ，持续时间 16</pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>releaseTimes.length == n</code></li>
 * <li><code>keysPressed.length == n</code></li>
 * <li><code>2 <= n <= 1000</code></li>
 * <li><code>1 <= releaseTimes[i] <= 10<sup>9</sup></code></li>
 * <li><code>releaseTimes[i] < releaseTimes[i+1]</code></li>
 * <li><code>keysPressed</code> 仅由小写英文字母组成</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>字符串</li></div></div><br><div><li>👍 60</li><li>👎 0</li></div>
 */
public class SlowestKey {

  public static void main(String[] args) {
    Solution solution = new SlowestKey().new Solution();
    System.out.println(solution.slowestKey(new int[]{1, 2}, "ba"));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {

      int maxReleaseTime = 0;
      char slowestKey = keysPressed.charAt(0);

      for (int i = 0; i < releaseTimes.length; i++) {

        char key = keysPressed.charAt(i);
        int releaseTime = i == 0 ? releaseTimes[i] : releaseTimes[i] - releaseTimes[i - 1];

        if (releaseTime >= maxReleaseTime) {
          if (releaseTime == maxReleaseTime) {
            if (key > slowestKey) {
              slowestKey = key;
            }
            continue;
          }
          maxReleaseTime = releaseTime;
          slowestKey = key;
        }
      }

      return slowestKey;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}