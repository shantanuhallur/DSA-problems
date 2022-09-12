class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int previous = 0;
        int current = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char letter = s.charAt(i);
            switch (letter) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
            }
            sum = current >= previous ? sum + current : sum - current;
            previous = current;
        }
        return sum;
    }
}