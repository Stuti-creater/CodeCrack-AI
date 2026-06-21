package com.stuti.interview_platform.service;

import org.springframework.stereotype.Service;

@Service
public class MainGeneratorService {

    public String generateBinarySearchMain(
        int[] nums,
        int target
){

    StringBuilder arr =
            new StringBuilder();

    for(int i=0;i<nums.length;i++){

        arr.append(nums[i]);

        if(i != nums.length - 1){
            arr.append(",");
        }

    }

    return
        "public class Main {\n" +
        "\n" +
        "    public static void main(String[] args){\n" +
        "\n" +
        "        Solution s = new Solution();\n" +
        "\n" +
        "        int[] nums = {" + arr + "};\n" +
        "\n" +
        "        System.out.println(\n" +
        "            s.search(nums," + target + ")\n" +
        "        );\n" +
        "\n" +
        "    }\n" +
        "}";
}
}

