class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> required = new HashMap<>();

        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int have = 0;
        int need = required.size();

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if (required.containsKey(c) &&
                window.get(c).equals(required.get(c))) {
                have++;
            }

            while (have == need) {

                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                if (required.containsKey(leftChar) &&
                    window.get(leftChar).equals(required.get(leftChar))) {
                    have--;
                }

                window.put(leftChar, window.get(leftChar) - 1);

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLength);
    }
}
