package leetCode;

import java.util.HashMap;

public class _535EncodeAndDecodeShortURL {
    HashMap<String, String> map = new HashMap<>();
    HashMap<Integer, String> map2 = new HashMap<>();
    String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWSYZ";
    // Encodes a URL to a shortened URL.
    public String encode1(String longUrl) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < longUrl.length(); i++){
            char c = longUrl.charAt(i);
            sb.append(c % 62);
        }
        while(map.containsKey(sb)){
            sb.append(Math.random() * 100);
        }
        map.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode2(String longUrl) {
        map2.put(longUrl.hashCode(), longUrl);
        return Integer.toString(longUrl.hashCode());

    }

    // Decodes a shortened URL to its original URL.
    public String decode2(String shortUrl) {
        return map2.get(Integer.parseInt(shortUrl));
    }
}
