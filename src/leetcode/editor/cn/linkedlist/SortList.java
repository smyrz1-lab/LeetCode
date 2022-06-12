  //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1529 👎 0

  
  package com.shuzijun.leetcode.editor.en.linkedlist;

  public class SortList{
      public static void main(String[] args) {
           Solution solution = new SortList().new Solution();
      }
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for(ListNode p = head;p != null;p = p.next) n ++;

        for(int i = 1;i < n;i *= 2)
        {
            ListNode dummy = new ListNode(-1), cur = dummy;
            for(int j = 1;j <= n;j += i * 2)
            {
                ListNode p = head, q = p;
                for(int k = 0;k < i && q != null;k ++) q = q.next;
                ListNode o = q;
                for(int k = 0;k < i && o != null;k ++) o = o.next;

                int l = 0,r = 0;
                while(l < i && r < i && p != null && q != null)
                {
                    if(p.val <= q.val)
                    {
                        cur.next = p;
                        p = p.next;
                        l ++;
                    }
                    else
                    {
                        cur.next = q;
                        q = q.next;
                        r ++;
                    }
                    cur = cur.next;
                }
                while(l < i && p != null) {cur = cur.next = p; p = p.next; l ++;}
                while(r < i && q != null) {cur = cur.next = q; q = q.next; r ++;}
                head = o;
            }
            cur.next = null;
            head = dummy.next;
        }

        return head;
    }
    /*public ListNode sortList(ListNode head) {
        return mergeSort(head, null);

    }
    public ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        return merge(mergeSort(head, mid), mergeSort(mid, tail));
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode temp1 = l;
        ListNode temp2 = r;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                pre.next = temp1;
                temp1 = temp1.next;
            } else {
                pre.next = temp2;
                temp2 = temp2.next;
            }
            pre = pre.next;
        }
        pre.next = temp1 == null ? temp2 : temp1;
        return dummy.next;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

  }