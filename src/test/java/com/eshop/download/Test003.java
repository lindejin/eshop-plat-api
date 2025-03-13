package com.eshop.download;

public class Test003 {
    public static void main(String[] args) {
        //String downloadUrl = "https://open-fs-va.tiktokshop.com/wsos_v2/oec_fulfillment_doc_tts/object/wsos67d126cbbad08b05?expire=1741846609&skipCookie=true&timeStamp=1741760209&sign=fb5bf55b290c0672d24bbac73857d3502815db4219bbccf4971dd507e3d8080a"; // 下载URL

        String downloadUrl = "https://open-fs-sg.tiktokshop.com/wsos_v2/oec_fulfillment_doc_tts/object/wsos67d137fd01410b37?expire=1741851010&skipCookie=true&timeStamp=1741764610&sign=90839ce673dd32c8418f1022368406d4eda30a72f1105e849383d1593d8fd54d";
        String modifiedUrl = downloadUrl;
        if (downloadUrl.contains("open-fs-va.tiktokshop.com")) {
            modifiedUrl = downloadUrl.replace("open-fs-va.tiktokshop.com", "us.vogocmerp.com/tiktokshop");
        } else if (downloadUrl.contains("open-fs-sg.tiktokshop.com")) {
            modifiedUrl = downloadUrl.replace("open-fs-sg.tiktokshop.com", "us.vogocmerp.com/tiktokshop");
        }
        System.out.println(modifiedUrl);
    }
}
