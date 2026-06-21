
package com.stuti.interview_platform.service;

import com.stuti.interview_platform.model.Question;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuestionService {
        public Map<String, Question> getAllQuestions(){
    return questions;
}

    private final Map<String, Question> questions =
            new HashMap<>();

    public QuestionService() {

        // ==========================
        // ARRAYS QUESTIONS
        // ==========================

       questions.put("Two Sum",
        new Question(
    "Two Sum",
    "Easy",
    "Google",
    "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.",
    "Input: nums=[2,7,11,15], target=9\nOutput: [0,1]",
    "2 ≤ nums.length ≤ 10⁴",
    "Use a HashMap to store previously seen numbers.",
    "Arrays"
)
);

        questions.put("Move Zeroes",
        new Question(
    "Move Zeroes",
    "Easy",
    "Google",
    "Given an integer array nums, move all 0's to the end while maintaining the relative order of the non-zero elements.",
    "Input: [0,1,0,3,12]\nOutput: [1,3,12,0,0]",
    "1 ≤ nums.length ≤ 10⁴",
    "Use the two-pointer approach.",
    "Arrays"
)
);
        questions.put("Kadane Algorithm",
        new Question(
    "Kadane Algorithm",
    "Medium",
    "Google",
    "Find the contiguous subarray with the largest sum.",
    "Input: [-2,1,-3,4,-1,2,1,-5,4]\nOutput: 6",
    "1 ≤ n ≤ 10⁵",
    "Keep track of current and maximum sum.",
    "Arrays"
)
);

        questions.put("Best Time to Buy and Sell Stock",
        new Question(
    "Best Time to Buy and Sell Stock",
    "Easy",
    "Google",
    "Find the maximum profit by choosing a single day to buy and a different day to sell.",
    "Input: [7,1,5,3,6,4]\nOutput: 5",
    "1 ≤ prices.length ≤ 10⁵",
    "Track minimum price seen so far.",
    "Arrays"
)
);

        questions.put("Contains Duplicate",
        new Question(
    "Contains Duplicate",
    "Easy",
    "Google",
    "Determine if any value appears at least twice in the array.",
    "Input: [1,2,3,1]\nOutput: true",
    "1 ≤ nums.length ≤ 10⁵",
    "Use a HashSet.",
    "Arrays"
)
);

        questions.put("Product of Array Except Self",
        new Question(
    "Product of Array Except Self",
    "Medium",
    "Google",
    "Return an array where answer[i] is equal to the product of all elements except nums[i].",
    "Input: [1,2,3,4]\nOutput: [24,12,8,6]",
    "2 ≤ nums.length ≤ 10⁵",
    "Use prefix and suffix products.",
    "Arrays"
)
);

        // ==========================
        // BINARY SEARCH QUESTIONS
        // ==========================

        questions.put("Binary Search",
                new Question(
        "Binary Search",
        "Easy",
        "Google",
        "Search target in sorted array using binary search.",
        "Input: nums=[-1,0,3,5,9,12], target=9\nOutput: 4",
        "class Solution {\n" +
                "    public int search(int[] nums, int target) {\n" +
                "        \n" +
                "    }\n" +
                "}",
        "Use left, right and mid pointers.",
        "Binary Search"
)
        );

        questions.put("Koko Eating Bananas",
                new Question(
        "Koko Eating Bananas",
        "Medium",
        "Google",
        "Koko loves bananas. Find minimum eating speed to finish in h hours.",
        "Input: piles=[3,6,7,11], h=8\nOutput: 4",
        "class Solution {\n" +
                "    public int minEatingSpeed(int[] piles, int h) {\n" +
                "        \n" +
                "    }\n" +
                "}",
        "Use Binary Search on the answer space.",
        "Binary Search"
)
        );
        // ==========================
// STRINGS QUESTIONS
// ==========================

questions.put("Valid Anagram",
        new Question(
                "Valid Anagram",
                "Easy",
                "Amazon",
                "Given two strings s and t, return true if t is an anagram of s, and false otherwise.",
                "Input: s = \"anagram\", t = \"nagaram\"\nOutput: true",
                "1 <= s.length, t.length <= 5 × 10^4",
                "Count character frequencies using an array or HashMap.",
                "Strings"
        ));

questions.put("Longest Common Prefix",
        new Question(
                "Longest Common Prefix",
                "Easy",
                "Google",
                "Write a function to find the longest common prefix string amongst an array of strings.",
                "Input: [\"flower\",\"flow\",\"flight\"]\nOutput: \"fl\"",
                "1 <= strs.length <= 200",
                "Compare characters column by column.",
                "Strings"
        ));

questions.put("Valid Palindrome",
        new Question(
                "Valid Palindrome",
                "Easy",
                "Facebook",
                "Determine if a string is a palindrome after removing non-alphanumeric characters.",
                "Input: \"A man, a plan, a canal: Panama\"\nOutput: true",
                "1 <= s.length <= 2 × 10^5",
                "Use two pointers.",
                "Strings"
        ));
        // ==========================
// LINKED LIST QUESTIONS
// ==========================

questions.put("Reverse Linked List",
        new Question(
                "Reverse Linked List",
                "Easy",
                "Microsoft",
                "Reverse a singly linked list.",
                "Input: 1→2→3→4→5\nOutput: 5→4→3→2→1",
                "The number of nodes is in the range [0, 5000]",
                "Use prev, current and next pointers.",
                "LinkedLists"
        ));

questions.put("Middle of the Linked List",
        new Question(
                "Middle of the Linked List",
                "Easy",
                "Amazon",
                "Return the middle node of a linked list.",
                "Input: 1→2→3→4→5\nOutput: Node 3",
                "1 <= number of nodes <= 100",
                "Use slow and fast pointers.",
                "LinkedLists"
        ));
        // ==========================
// TREE QUESTIONS
// ==========================

questions.put("Maximum Depth of Binary Tree",
        new Question(
                "Maximum Depth of Binary Tree",
                "Easy",
                "Amazon",
                "Find the maximum depth of a binary tree.",
                "Input: root = [3,9,20,null,null,15,7]\nOutput: 3",
                "The number of nodes is in the range [0, 10^4]",
                "Use DFS recursion.",
                "Trees"
        ));

questions.put("Same Tree",
        new Question(
                "Same Tree",
                "Easy",
                "Google",
                "Determine if two binary trees are the same.",
                "Input: p=[1,2,3], q=[1,2,3]\nOutput: true",
                "The number of nodes is in the range [0,100]",
                "Compare nodes recursively.",
                "Trees"
        ));
        // ==========================
// DP QUESTIONS
// ==========================

questions.put("Climbing Stairs",
        new Question(
                "Climbing Stairs",
                "Easy",
                "Google",
                "Count the number of distinct ways to climb to the top.",
                "Input: n = 3\nOutput: 3",
                "1 <= n <= 45",
                "Recognize Fibonacci relation.",
                "DP"
        ));

questions.put("House Robber",
        new Question(
                "House Robber",
                "Medium",
                "Amazon",
                "Find the maximum amount of money you can rob.",
                "Input: [2,7,9,3,1]\nOutput: 12",
                "1 <= nums.length <= 100",
                "Use DP.",
                "DP"
        ));
        // ==========================
// GRAPH QUESTIONS
// ==========================

questions.put("Number of Islands",
        new Question(
                "Number of Islands",
                "Medium",
                "Google",
                "Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.",
                "Input: grid = [[1,1,0],[0,1,0],[1,0,1]]\nOutput: 3",
                "1 <= m,n <= 300",
                "Use DFS or BFS to explore connected components.",
                "Graphs"
        ));

questions.put("Flood Fill",
        new Question(
                "Flood Fill",
                "Easy",
                "Amazon",
                "Perform a flood fill on the given image.",
                "Input: image=[[1,1,1],[1,1,0],[1,0,1]], sr=1, sc=1, color=2\nOutput: [[2,2,2],[2,2,0],[2,0,1]]",
                "1 <= image.length <= 50",
                "Use DFS traversal.",
                "Graphs"
        ));
        // ==========================
// STACK QUESTIONS
// ==========================

questions.put("Valid Parentheses",
        new Question(
                "Valid Parentheses",
                "Easy",
                "Google",
                "Determine if the input string is valid.",
                "Input: \"()[]{}\"\nOutput: true",
                "1 <= s.length <= 10^4",
                "Use a stack to match brackets.",
                "Stacks"
        ));

questions.put("Min Stack",
        new Question(
                "Min Stack",
                "Medium",
                "Amazon",
                "Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.",
                "Implement MinStack class.",
                "At most 3 × 10^4 calls.",
                "Maintain an additional stack for minimum values.",
                "Stacks"
        ));
        // ==========================
// QUEUE QUESTIONS
// ==========================

questions.put("Implement Queue using Stacks",
        new Question(
                "Implement Queue using Stacks",
                "Easy",
                "Microsoft",
                "Implement a FIFO queue using two stacks.",
                "Implement MyQueue class.",
                "At most 100 operations.",
                "Use two stacks.",
                "Queues"
        ));

questions.put("First Unique Character in a String",
        new Question(
                "First Unique Character in a String",
                "Easy",
                "Amazon",
                "Find the first non-repeating character.",
                "Input: \"leetcode\"\nOutput: 0",
                "1 <= s.length <= 10^5",
                "Use frequency counting.",
                "Queues"
        ));
}

    public Question getQuestion(String name) {
        return questions.get(name);
    }
}

