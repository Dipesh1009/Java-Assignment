class EString {
    String str;

    EString() {}

    EString(String str) {
        this.str = str;
    }

    void encrypt(int key) {
        String temp = new String();

        for (char c : str.toCharArray()) {
            if ((int)c < 87 || (int)c < 119) {
                temp += (char)(key + (int)c);
            }
            else {
                switch (c) {
                    case 'w': case 'x': case 'y': case 'z':
                        temp += (char)(key + (int)c - 26);
                        break;
                    case 'W': case 'X': case 'Y': case 'Z':
                        temp += (char)(key + (int)c - 26);
                        break;
                }
            }
        }
        str = temp;
    }

    void decrypt(int key) {
        String temp = new String();

        for (char c : str.toCharArray()) {
            if ((int)c > 68 || (int)c > 100) {
                temp += (char)((int)c - key);
            }
            else {
                switch (c) {
                    case 'a': case 'b': case 'c': case 'd':
                        temp += (char)((int)c + 26 - key);
                        break;
                    case 'A': case 'B': case 'C': case 'D':
                        temp += (char)((int)c + 26 - key);
                        break;
                }
            }
        }
        str = temp;
    }

    char charAt(int index) {
        return str.charAt(index);
    }
    
    int countOccurrence(char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
    int countOccurrence(char c, int startIndex) {
        int count = 0;
        for (int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    int countOccurrence(String s) {
        int count = 0;
        for (int i = 0; i < str.length() - s.length(); i++) {
            if (str.substring(i, i+s.length()).equals(s)) {
                count++;
            }
        }
        return count;
    }
    int countOccurrence(String s, int startIndex) {
        int count = 0;
        for (int i = startIndex; i < str.length() - s.length(); i++) {
            if (str.substring(i, i+s.length()).equals(s)) {
                count++;
            }
        }
        return count;
    }

    int countPattern(String s, int d, char m) {
        int count = 0;
        if (d >= 0) {
            for (int i = 0; i <= str.length() - s.length() - d ; i++) {
                System.out.println(str.charAt(i));
                if (str.substring(i, i+s.length()).equals(s) && str.charAt(i + s.length() + d - 1) == m) {
                    System.out.println(str.substring(i, i+s.length()));
                    count++;
                } 
            }
        }
        else {
            for (int i = str.length() - s.length() - 1; i >= -d; i--) {
                if (str.substring(i, i+s.length()).equals(s) && str.charAt(i+d) == m) {
                    count++;
                } 
            }
        }

        return count;
    }

    char charAtReverseIndex(int index) {
        if (index > 0 || -index > str.length()) {
            System.out.println("Invalid index");
            return '\0';
        } 
        return str.charAt(str.length() + index);
    }

    public String toString() {
        return str;
    }

    void set(String str) {
        this.str = str;
    }
}

class EStringTest {
    public static void main(String[] args) {
        EString str = new EString("Java is so fun");
        System.out.println(str);
        System.out.println("Char at reverse index: " + str.charAtReverseIndex(-3));
        str.set("JaVa");
        str.encrypt(4);
        System.out.println("Encrypted: " + str);
        str.decrypt(4);
        System.out.println("Decrypted: " + str);
        str.set("aasjsaajswjsjajauwsjauajabaccabacddaabacbbacaadcdabac");
        System.out.println("Occurrence of 'a': " + str.countOccurrence('a'));
        System.out.println("Occurrence of 'ja': " + str.countOccurrence("ja"));
        System.out.println("Occurrence of 'j' from index 20: " + str.countOccurrence("j", 20));
        System.out.println("Occurrence of 'a' from index 20: " + str.countOccurrence('a', 20));
        System.out.println("Pattern 'ab' at distance 2 with 'c': " + str.countPattern("ab", 2, 'c'));
        System.out.println("Pattern 'ab' at distance 2 with 'c': " + str.countPattern("ab", -2, 'c'));

    }
}