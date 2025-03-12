package com.eshop.download;

import java.util.HashMap;
import java.util.Map;

/**
 * 用文件头判断。直接读取文件的前几个字节。 常用文件的文件头如下： JPEG (jpg)，文件头：FFD8FF PNG (png)，文件头：89504E47
 * GIF (gif)，文件头：47494638 TIFF (tif)，文件头：49492A00 Windows Bitmap (bmp)，文件头：424D
 * CAD (dwg)，文件头：41433130 Adobe Photoshop (psd)，文件头：38425053 Rich Text Format
 * (rtf)，文件头：7B5C727466 XML (xml)，文件头：3C3F786D6C HTML (html)，文件头：68746D6C3E
 * Email [thorough only] (eml)，文件头：44656C69766572792D646174653A Outlook Express
 * (dbx)，文件头：CFAD12FEC5FD746F Outlook (pst)，文件头：2142444E MS Word/Excel
 * (xls.or.doc)，文件头：D0CF11E0 MS Access (mdb)，文件头：5374616E64617264204A
 * WordPerfect (wpd)，文件头：FF575043 Postscript.
 * (eps.or.ps)，文件头：252150532D41646F6265 Adobe Acrobat (pdf)，文件头：255044462D312E
 * Quicken (qdf)，文件头：AC9EBD8F Windows Password (pwl)，文件头：E3828596 ZIP Archive
 * (zip)，文件头：504B0304 RAR Archive (rar)，文件头：52617221 Wave (wav)，文件头：57415645 AVI
 * (avi)，文件头：41564920 Real Audio (ram)，文件头：2E7261FD Real Media (rm)，文件头：2E524D46
 * MPEG (mpg)，文件头：000001BA MPEG (mpg)，文件头：000001B3 Quicktime (mov)，文件头：6D6F6F76
 * Windows Media (asf)，文件头：3026B2758E66CF11 MIDI (mid)，文件头：4D546864
 *
 * @author zhangnana
 */
public class FileTypeUtils {
    public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();
    static{
        getAllFileType(); //初始化文件类型信息
    }
    private static void getAllFileType()
    {
        //JPEG (jpg)
        FILE_TYPE_MAP.put("ffd8ff", "jpg");
        //PNG (png)
        FILE_TYPE_MAP.put("89504e", "png");
        //GIF (gif)
        FILE_TYPE_MAP.put("474946", "gif");
        //TIFF (tif)
        FILE_TYPE_MAP.put("49492a", "tif");
        //16色位图(bmp)
        FILE_TYPE_MAP.put("424d22", "bmp");
        //24位位图(bmp)
        FILE_TYPE_MAP.put("424d82", "bmp");
        //256色位图(bmp)
        FILE_TYPE_MAP.put("424d8e", "bmp");
        //CAD (dwg)
        FILE_TYPE_MAP.put("414331", "dwg");
        //HTML (html)
        FILE_TYPE_MAP.put("3c2144", "html");
        //HTM (htm)
        FILE_TYPE_MAP.put("3c2164", "htm");
        //css
        FILE_TYPE_MAP.put("48544d", "css");
        //js
        FILE_TYPE_MAP.put("696b2e", "js");
        //Rich Text Format (rtf)
        FILE_TYPE_MAP.put("7b5c72", "rtf");
        //Photoshop (psd)
        FILE_TYPE_MAP.put("384250", "psd");
        //Email [Outlook Express 6] (eml)
        FILE_TYPE_MAP.put("46726f", "eml");
        //MS Excel 注意：word、msi 和 excel的文件头一样
        FILE_TYPE_MAP.put("d0cf11", "doc");
        //MS Access (mdb)
        FILE_TYPE_MAP.put("537461", "mdb");
        FILE_TYPE_MAP.put("252150", "ps");
        //Adobe Acrobat (pdf)
        FILE_TYPE_MAP.put("255044", "pdf");
        //rmvb/rm相同
        FILE_TYPE_MAP.put("2e524d", "rmvb");
        //flv与f4v相同
        FILE_TYPE_MAP.put("464c56", "flv");
        FILE_TYPE_MAP.put("000000", "mp4");
        FILE_TYPE_MAP.put("494433", "mp3");
        FILE_TYPE_MAP.put("000001", "mpg");
        //wmv与asf相同
        FILE_TYPE_MAP.put("3026b2", "wmv");
        //Wave (wav) 或 avi
        FILE_TYPE_MAP.put("524946", "wav");
        //MIDI (mid)
        FILE_TYPE_MAP.put("4d5468", "mid");
        // 压缩文件格式 zip jar docx文件 51job简历。mht
        FILE_TYPE_MAP.put("504b03", "zip");
        FILE_TYPE_MAP.put("526172", "rar");
        FILE_TYPE_MAP.put("235468", "ini");
        //可执行文件
        FILE_TYPE_MAP.put("4d5a90", "exe");
        //jsp文件
        FILE_TYPE_MAP.put("3c2540", "jsp");
        //MF文件
        FILE_TYPE_MAP.put("4d616e", "mf");
        //xml文件
        FILE_TYPE_MAP.put("3c3f78", "xml");
        //sql文件
        FILE_TYPE_MAP.put("494e53", "sql");
        //java文件
        FILE_TYPE_MAP.put("706163", "java");
        //bat文件
        FILE_TYPE_MAP.put("406563", "bat");
        //gz文件
        FILE_TYPE_MAP.put("1f8b08", "gz");
        //bat文件
        FILE_TYPE_MAP.put("6c6f67", "properties");
        //class文件
        FILE_TYPE_MAP.put("cafeba", "class");
        FILE_TYPE_MAP.put("495453", "chm");
        FILE_TYPE_MAP.put("040000", "mxp");
        FILE_TYPE_MAP.put("643130", "torrent");
        //猎聘、智联简历。htm
        FILE_TYPE_MAP.put("3c6874", "htm");
        //Quicktime (mov)
        FILE_TYPE_MAP.put("6D6F6F", "mov");
        //WordPerfect (wpd)
        FILE_TYPE_MAP.put("FF5750", "wpd");
        //Outlook Express (dbx)
        FILE_TYPE_MAP.put("CFAD12", "dbx");
        //Outlook (pst)
        FILE_TYPE_MAP.put("214244", "pst");
        //Quicken (qdf)
        FILE_TYPE_MAP.put("AC9EBD", "qdf");
        //Windows Password (pwl)
        FILE_TYPE_MAP.put("E38285", "pwl");
        //Real Audio (ram)
        FILE_TYPE_MAP.put("2E7261", "ram");

        FILE_TYPE_MAP.put("7b2265", "amr");
    }

    /**
     * byte数组转换成16进制字符串
     *
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 根据文件流读取图片文件真实类型
     *
     * @param
     * @return jpg、jpeg、png、gif、bmp
     */
    public static String getTypeByStream(byte[]  fileByte) {
        String res = null;

            byte[] bytes = new byte[3];
            System.arraycopy(fileByte, 0, bytes, 0, bytes.length);
            byte[] b = bytes;
            res = FILE_TYPE_MAP.get(bytesToHexString(b));

        return res;
    }
}
